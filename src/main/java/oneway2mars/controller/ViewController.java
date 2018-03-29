package oneway2mars.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.NonAccumulableResource;
import oneway2mars.model.resource.Resource;

public class ViewController {

    private AlphaAlphaModel model;

    public ViewController (AlphaAlphaModel model) {
        this.model = model;
    }

    public void updateView(Nifty nifty) {

        Element outputEngine = nifty.getCurrentScreen().findElementById("outputEngine");

        String outputEngines = "";

        for(Engine eng : model.getEngines()) {
            outputEngines += eng.getName() + ": " +
                    (eng.isActivated()?" activ \n":" not activ \n");
        }

        outputEngine.getRenderer(TextRenderer.class).setText(outputEngines);


        Element outputResource = nifty.getCurrentScreen().findElementById("outputResource");

        String outputResources = "";
        for(Resource res : model.getResources()) {
            outputResources += res.getClass()
                    .getSimpleName
                            () + ": " + res.getAmount() + (res.getClass().isAssignableFrom
                    (NonAccumulableResource.class)? " / " + ((NonAccumulableResource) res)
                    .getUnusedAmount() + "\n" : "\n");
        }

        outputResource.getRenderer(TextRenderer.class).setText(outputResources);
    }
}
