package testpackage.states;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.asset.AssetManager;
import com.jme3.audio.AudioRenderer;
import com.jme3.input.InputManager;
import com.jme3.material.Material;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import testpackage.AlphaAlphaMarsApplication;

public class ImageTestState extends BaseAppState {

    private AlphaAlphaMarsApplication app;
    private AssetManager assetManager;
    private InputManager inputManager;
    private AudioRenderer audioRenderer;
    private ViewPort guiViewPort;
    protected Geometry image;
    private Node rootNode;

    @Override
    protected void initialize(Application application) {

        this.app = (AlphaAlphaMarsApplication) application;
        this.assetManager = app.getAssetManager();
        this.inputManager = app.getInputManager();
        this.audioRenderer= app.getAudioRenderer();
        this.guiViewPort  = app.getGuiViewPort();
        this.rootNode = app.getRootNode();


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


    }
    @Override
    protected void cleanup(Application application) {

    }
    @Override
    protected void onEnable() {
        rootNode.attachChild(image);              // make the cube appear in the scene

    }
    @Override
    protected void onDisable() {
        rootNode.detachAllChildren();              // make the cube appear in the scene

    }
}
