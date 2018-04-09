package oneway2mars.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.NonAccumulableResource;
import oneway2mars.model.resource.Resource;

public class ViewController {

	private AlphaAlphaModel model;
	private String cosmonautString = "";

	public ViewController(AlphaAlphaModel model) {
		this.model = model;
	}

	public void updateView(Nifty nifty) {

		displayEngines(nifty);
		displayResources(nifty);
		displayCosmonauts(nifty);
		displayEvents(nifty);
	}

	private void displayEngines(Nifty nifty) {
		Element outputEngine = nifty.getCurrentScreen().findElementById("outputEngine");

		String outputEngines = "";

		for (Engine eng : model.getEngines()) {
			outputEngines += eng.getName() + ": " +
					(eng.isActivated() ? " activ " : " not activ ") + ", Condition: " + eng
					.getCondition() + "\n";
		}

		outputEngine.getRenderer(TextRenderer.class).setText(outputEngines);
	}

	private void displayResources(Nifty nifty) {
		Element outputResource = nifty.getCurrentScreen().findElementById("outputResource");

		String outputResources = "";
		for (Resource res : model.getResources()) {
			outputResources += res.getClass()
					.getSimpleName
							() + ": " + res.getAmount() + (NonAccumulableResource.class.isAssignableFrom(res
					.getClass()) ? " / " + res.getConsumedNow() + "\n" : "\n");
		}

		outputResource.getRenderer(TextRenderer.class).setText(outputResources);

	}

	private void displayCosmonauts(Nifty nifty) {

		cosmonautString = "";

		Element outputCosmonauts = nifty.getCurrentScreen().findElementById("outputCosmonaut");

		for (Cosmonaut cos : model.getCosmonauts()) {
			cosmonautString += cos.getClass().getSimpleName() + "\n ";
			cos.getHealthSet().forEach(hel -> {
				cosmonautString += hel.getClass().getSimpleName() + ": " + hel.getHealthState()
						+ " ";
			});
			cosmonautString += "\n";
			cos.getNeedSet().forEach(need -> {
				cosmonautString += need.getClass().getSimpleName() + " - Urgency: " + need
						.getUrgency() + " ";
			});
			cosmonautString += "\n Lebendig: " + cos.isAlive();

		}

		outputCosmonauts.getRenderer(TextRenderer.class).setText(cosmonautString);

	}

	private void displayEvents(Nifty nifty) {

		Element outputEvent = nifty.getCurrentScreen().findElementById("outputEvent");
		String eventString = "";
		boolean gameOver = false;
		if (model.getCosmonauts().stream().anyMatch(cos -> !cos.isAlive())) {
			eventString = "Siegmund ist tot. Das Spiel ist aus.";
			outputEvent.getRenderer(TextRenderer.class).setText(eventString);
		}


	}

}
