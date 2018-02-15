package testpackage;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class TestSimpleApplication extends SimpleApplication{

    protected Geometry image;
    public static void main(String[] args){
        TestSimpleApplication app = new TestSimpleApplication();

            //do some configuration
        app.setShowSettings(false);
        app.start(); // start the game
    }


    @Override
    public void simpleInitApp() {

            //configuration
        assetManager.registerLocator("C:\\Users\\seimonq\\Pictures\\oneWay2Mars\\", FileLocator.class);

            //create scene
        Box b = new Box(2, 2, 0); // create cube shape
        image = new Geometry("Box", b);  // create cube geometry from the shape
        Material tripToMars = new Material(
                assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        tripToMars.setTexture("ColorMap",
                assetManager.loadTexture("trip_to_mars.jpg"));


        image.setMaterial(tripToMars);                   // set the cube's material
        rootNode.attachChild(image);              // make the cube appear in the scene
    }
    /* Use the main event loop to trigger repeating actions. */
    @Override
    public void simpleUpdate(float tpf) {

        // make the player rotate:
        image.rotate(0, 1*tpf, 0);
    }

}
