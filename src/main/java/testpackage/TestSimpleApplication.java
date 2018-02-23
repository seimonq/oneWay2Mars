package testpackage;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.font.BitmapText;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;

public class TestSimpleApplication extends SimpleApplication{

    protected Geometry image;
    protected Geometry movingBox;

    public static void main(String[] args){
        TestSimpleApplication app = new TestSimpleApplication();

            //do some configuration
        app.setShowSettings(false);
        app.setDisplayFps(false);
        app.setDisplayStatView(false);


        app.start(); // start the game
    }


    @Override
    public void simpleInitApp() {

            //configuration
        flyCam.setEnabled(false);

            //this is adding a location
        assetManager.registerLocator(System.getProperty("user.dir") + "/src/rsc/pictures/", FileLocator.class);

            //binding keys
        inputManager.addMapping("Up",  new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("Down",  new KeyTrigger(KeyInput.KEY_DOWN));
        inputManager.addMapping("Left",  new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("Right",  new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addListener(analogListener, new String[]{"Up", "Down","Left","Right"});

            //create scene
        Box b = new Box(5.5f, 5.5f, 0); // create cube shape
        Box c = new Box(1, 1, 0.5f); // create cube shape

            //background
        image = new Geometry("Box", b);  // create cube geometry from the shape
        Material tripToMars = new Material(
                assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        tripToMars.setTexture("ColorMap",
                assetManager.loadTexture("image_mars.jpg"));
            //control box by keys
        movingBox = new Geometry("movingBox", c);
        Material defaulty = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        defaulty.setTexture("ColorMap", assetManager.loadTexture(
                "cartoon_return_from_mars.jpg"));
        movingBox.setMaterial(defaulty);

            //attach to sceneGraph
        image.setMaterial(tripToMars);                   // set the cube's material
        image.move(0,1,0);
        rootNode.attachChild(image);              // make the cube appear in the scene
        rootNode.attachChild(movingBox);

            // Display a line of text with a default font
        guiNode.detachAllChildren();
        guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
        BitmapText helloText = new BitmapText(guiFont, false);
        helloText.setSize(guiFont.getCharSet().getRenderedSize());
        helloText.setText("Hello Mars");
        helloText.setLocalTranslation(300, helloText.getLineHeight(), 0);
        guiNode.attachChild(helloText);
    }
    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {

        //your updates here
    }


    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {

            if (name.equals("Up")) {
                movingBox.move(0,1*tpf,0);
            }
            if (name.equals("Down")) {
                movingBox.move(0,-1*tpf,0);
            }
            if (name.equals("Left")) {
                movingBox.move(-1*tpf,0,0);
            }
            if (name.equals("Right")) {
                movingBox.move(1*tpf,0,0);
            }

        }
    };
}
