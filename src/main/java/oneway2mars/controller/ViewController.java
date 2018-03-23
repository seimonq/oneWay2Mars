package oneway2mars.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import oneway2mars.model.AlphaAlphaModel;

public class ViewController {

    private AlphaAlphaModel model;

    public ViewController (AlphaAlphaModel model) {
        this.model = model;
    }

    public void updateView(Nifty nifty) {

        Element outputEngine = nifty.getCurrentScreen().findElementById("outputEngine");
        String engineName = model.getEngines().get(0).getName();
        String engineState = model.getEngines().get(0).isActivated() ? "active" : "not active";

        outputEngine.getRenderer(TextRenderer.class).setText("Engine "+engineName+" :"+engineState);

        String consumingRes = model.getEngines().get(0).getConsumerType().getSimpleName();
        String producingRes = model.getEngines().get(0).getProducerType().getSimpleName();

        Element outputResource = nifty.getCurrentScreen().findElementById("outputResource");
        outputResource.getRenderer(TextRenderer.class).setText(consumingRes + ": " + model.getResources().get(0)
                .getAmount().toString() + ", " + producingRes + ": " + model.getResources().get(1).getAmount().toString());
    }
}
