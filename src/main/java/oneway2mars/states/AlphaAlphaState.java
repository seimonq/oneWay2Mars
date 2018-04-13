package oneway2mars.states;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.model.event.Event;
import oneway2mars.screen.AlphaAlphaScreenController;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.Optional;

public class AlphaAlphaState extends BaseAppState {

	private Nifty nifty;
	private AlphaAlphaMarsApplication app;
	private NiftyJmeDisplay niftyDisplay;
	private Integer heartBeat;

	/**
	 * this method is executed after the state is initialized from simpleInitApp()
	 * it is important to pass the application instance to the actual controller of the xml file
	 * screen methods cannot access game data otherwise
	 *
	 * @param application
	 */
	@Override
	public void initialize(Application application) {

		this.app = (AlphaAlphaMarsApplication) application;


		niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
				app.getAssetManager(), app.getInputManager(), app.getAudioRenderer(), app.getGuiViewPort());
		nifty = niftyDisplay.getNifty();
		nifty.fromXml("alphaAlphaScreen.xml", "alphaAlphaScreen", new AlphaAlphaScreenController(this.app));

	}

	@Override
	public void update(float tpf) {
		if (heartBeat == null || heartBeat > InitialGameConstants.HEARTBEAT_PULSE) {
			heartBeat = 1;
		} else {
			heartBeat++;
		}
		//call every heartbeat by PULSE rate and only if no event awaits a decision
		if (heartBeat % InitialGameConstants.HEARTBEAT_PULSE == 0 && !app.getGameModel()
				.getEventAwaitsDecision().isPresent()) {

			//update game state
			app.getGameModel().setCurrentHeartbeat(incrementCurrentHeartbeat(app.getGameModel()
					.getCurrentHeartbeat()));

			app.getUcCosmonaut().satisfyNeeds(app.getGameModel().getCosmonauts(), app
					.getGameModel().getResources());
			app.getUcCosmonaut().calcRiskOfDeath(app.getGameModel().getCosmonauts());

			app.getUcResource().updateResources(app.getGameModel());

			app.getUcEvent().applyEventEffects(app.getGameModel());

			app.getGameModel().setEventAwaitsDecision(app.getUcEvent().optionForEvent(app
					.getGameModel()));
			//display game state
			app.getViewController().updateView(nifty);

		}
	}

	@Override
	public void cleanup(Application app) {
	}

	@Override
	public void onDisable() {
		app.getGuiViewPort().clearProcessors();

	}

	@Override
	public void onEnable() {
		app.getGuiViewPort().addProcessor(niftyDisplay);
		app.getGameController().initGame();
	}

	private Long incrementCurrentHeartbeat(Long heartbeat) {
		if (heartbeat == null) {
			heartbeat = 1L;
		} else {
			heartbeat++;
		}
		return heartbeat;
	}
}
