package testpackage;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.niftygui.NiftyJmeDisplay;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;
import de.lessvoid.nifty.Nifty;
import testpackage.nifty.MarsLandingStartScreen;

public class AlphaMarsApplication extends SimpleApplication {

    protected Geometry image;
    protected Geometry movingBox;

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

        app.start(); // start the game
    }


    @Override
    public void simpleInitApp() {

        doConfigurationAndBindung();

        createBackgroundImage();
            /** start Nifty example landing game*/
        NiftyJmeDisplay niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                assetManager, inputManager, audioRenderer, guiViewPort);
        Nifty nifty = niftyDisplay.getNifty();
        nifty.fromXml("testInterface.xml", "start",new MarsLandingStartScreen());

        guiViewPort.addProcessor(niftyDisplay);

    }

    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {
        //your updates here
    }


    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {

            if (name.equals("Up")) {
                movingBox.move(0, 1 * tpf, 0);
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
        inputManager.addListener(analogListener, new String[]{"Up", "Down", "Left", "Right"});

    }
    private void createBackgroundImage() {
        //create scene
        Box b = new Box(5.5f, 5.5f, 0); // create cube shape
        //background
        image = new Geometry("Box", b);  // create cube geometry from the shape
        Material tripToMars = new Material(
                assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        tripToMars.setTexture("ColorMap",
                assetManager.loadTexture("image_mars.jpg"));
        image.setMaterial(tripToMars);                   // set the cube's material
        image.move(0, 1, 0);

        //attach to sceneGraph
        rootNode.attachChild(image);              // make the cube appear in the scene

    }
    private void unusedFunctionWithMovingBox() {
        Box c = new Box(1, 1, 0.5f); // create cube shape

        //control box by keys
        movingBox = new Geometry("movingBox", c);

        Material defaulty = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        defaulty.setTexture("ColorMap", assetManager.loadTexture(
                "cartoon_return_from_mars.jpg"));
        movingBox.setMaterial(defaulty);
         rootNode.attachChild(movingBox);

    }
}
