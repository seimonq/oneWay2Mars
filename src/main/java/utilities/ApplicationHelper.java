package utilities;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

public class ApplicationHelper {

    protected ViewPort pv;


    private void setBackgroundImage(String imageName, AssetManager assetManager, AppSettings settings, RenderManager renderManager, ViewPort viewPort, Camera cam) {

        Picture p = new Picture("background");

        Material marsLandscape = new Material(
                assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        marsLandscape.setTexture("ColorMap",
                assetManager.loadTexture(imageName));

        p.setMaterial( marsLandscape );

        p.setWidth(settings.getWidth());
        p.setHeight(settings.getHeight());

        p.setPosition(0, 0);
        p.updateGeometricState();

        pv = renderManager.createPreView("background", cam);
        pv.setClearFlags(true, true, true);
        pv.attachScene(p);
        viewPort.setClearFlags(false, true, true);
    }
}
