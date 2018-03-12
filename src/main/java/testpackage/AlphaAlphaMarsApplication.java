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
import testpackage.model.AlphaAlphaModel;
import testpackage.nifty.AlphaAlphaScreenController;
import testpackage.nifty.MarsLandingStartScreen;
import testpackage.states.ImageTestState;

public class AlphaAlphaMarsApplication extends SimpleApplication {

    protected Geometry movingBox;
    protected BaseAppState marsLandingGame;
    protected BaseAppState imageMars;
    protected BaseAppState alphaAlphaScreen;


    private AlphaAlphaModel gameModel;

    public AlphaAlphaModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(AlphaAlphaModel gameModel) {
        this.gameModel = gameModel;
    }

    public static void main(String[] args) {
        AlphaAlphaMarsApplication app = new AlphaAlphaMarsApplication();

        //do some configuration before starting the app
        app.setShowSettings(false);
        app.setDisplayFps(false);
        app.setDisplayStatView(false);

        //constructor true means -> keep default settings plus specified custom settings
        AppSettings mySettings = new AppSettings(true);
        mySettings.setResolution(1024, 768);

        app.setSettings(mySettings);
        app.settings.setAudioRenderer(null);

        //app.gameModel = new AlphaAlphaModel(100);
        app.start(); // start the game

    }


    @Override
    public void simpleInitApp() {
        doConfigurationAndBindung();
        marsLandingGame = new MarsLandingStartScreen();
        imageMars = new ImageTestState();
        alphaAlphaScreen = new AlphaAlphaScreenController();

        gameModel = new AlphaAlphaModel(100);
        stateManager.attach(marsLandingGame);
        stateManager.attach(imageMars);
        stateManager.attach(alphaAlphaScreen);

            //attach gui here
        stateManager.getState(ImageTestState.class).setEnabled(true);
        stateManager.getState(AlphaAlphaScreenController.class).setEnabled(true);

        stateManager.getState(MarsLandingStartScreen.class).setEnabled(false);
    }

    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {
        //your updates here
    }



    private final ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean keyPressed, float tpf) {
            if(name.equals("L") && !keyPressed) {
                if(marsLandingGame.isEnabled()) {
                    stateManager.getState(MarsLandingStartScreen.class).setEnabled(false);
                    stateManager.getState(ImageTestState.class).setEnabled(true);
                } else {
                    stateManager.getState(MarsLandingStartScreen.class).setEnabled(true);
                    stateManager.getState(ImageTestState.class).setEnabled(false);
                }
            }
            if(name.equals("A") && !keyPressed) {
                if(marsLandingGame.isEnabled()) {
                    stateManager.getState(AlphaAlphaScreenController.class).setEnabled(false);
                    stateManager.getState(ImageTestState.class).setEnabled(true);
                } else {
                    stateManager.getState(AlphaAlphaScreenController.class).setEnabled(true);
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
        inputManager.addMapping( "L", new KeyTrigger(KeyInput.KEY_L));
        inputManager.addMapping( "A", new KeyTrigger(KeyInput.KEY_A));

        // inputManager.addListener(analogListener, new String[]{"Up", "Down", "Left", "Right"});
        inputManager.addListener(actionListener, new String[] {"A","L"});

    }

    //not in use currently
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
}
