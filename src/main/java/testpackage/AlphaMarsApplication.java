package testpackage;

import com.jme3.app.SimpleApplication;
import com.jme3.app.state.BaseAppState;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.scene.Geometry;
import com.jme3.system.AppSettings;
import testpackage.nifty.MarsLandingStartScreen;
import testpackage.states.ImageTestState;

public class AlphaMarsApplication extends SimpleApplication {

    protected Geometry movingBox;
    protected BaseAppState marsLandingGame;
    protected BaseAppState imageMars;

    public static void main(String[] args) {
        AlphaMarsApplication app = new AlphaMarsApplication();

        //do some configuration before starting the app
        app.setShowSettings(false);
        app.setDisplayFps(false);
        app.setDisplayStatView(false);

        //constructor true means -> keep default settings plus specified custom settings
        AppSettings mySettings = new AppSettings(true);
        mySettings.setResolution(1024, 768);

        app.setSettings(mySettings);
        app.settings.setAudioRenderer(null);
        app.start(); // start the game

    }


    @Override
    public void simpleInitApp() {
        doConfigurationAndBindung();
        marsLandingGame = new MarsLandingStartScreen();
        imageMars = new ImageTestState();

        stateManager.attach(marsLandingGame);
        stateManager.attach(imageMars);

            //attach gui here
        stateManager.getState(MarsLandingStartScreen.class).setEnabled(true);
        stateManager.getState(ImageTestState.class).setEnabled(false);

    }

    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {
        //your updates here
    }


    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {

            if (name.equals("Up")) {
                rootNode.getChild("movingBox").move(0, 1 * tpf, 0);
            }
            if (name.equals("Down")) {
                movingBox.move(0, -1 * tpf, 0);
            }
            if (name.equals("Left")) {
                movingBox.move(-1 * tpf, 0, 0);
            }
            if (name.equals("Right")) {
                movingBox.move(1 * tpf, 0, 0);
            }


        }
    };
    private final ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            if(name.equals("I")) {
                if(marsLandingGame.isEnabled()) {
                    stateManager.getState(MarsLandingStartScreen.class).setEnabled(false);
                    stateManager.getState(ImageTestState.class).setEnabled(true);
                } else {
                    stateManager.getState(MarsLandingStartScreen.class).setEnabled(true);
                    stateManager.getState(ImageTestState.class).setEnabled(false);
                }
            }
        }
    };
    private void doConfigurationAndBindung() {

        //configuration
        flyCam.setEnabled(false);

        //this is adding a location
        assetManager.registerLocator(System.getProperty("user.dir") + "/src/rsc/pictures/", FileLocator.class);
        assetManager.registerLocator(System.getProperty("user.dir") + "/src/rsc/nifty/", FileLocator.class);

        //binding keys
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_DOWN));
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addMapping( "I", new KeyTrigger(KeyInput.KEY_I));
        // inputManager.addListener(analogListener, new String[]{"Up", "Down", "Left", "Right"});
        inputManager.addListener(actionListener, new String[] {"I"});

    }

}
