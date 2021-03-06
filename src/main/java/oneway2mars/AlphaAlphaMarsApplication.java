package oneway2mars;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.FileLocator;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.scene.Geometry;
import com.jme3.system.AppSettings;
import oneway2mars.controller.*;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.screen.MarsLandingStartScreen;
import oneway2mars.states.AlphaAlphaState;
import oneway2mars.states.ImageTestState;

import java.util.Arrays;

public class AlphaAlphaMarsApplication extends SimpleApplication {

	protected Geometry movingBox;

	private AlphaAlphaModel gameModel;

	private UcResource ucResource;

	private UcCosmonaut ucCosmonaut;

	private UcEvent ucEvent;

	private GameController gameController;

	protected ViewController viewController;

	public ViewController getViewController() {
		return viewController;
	}

	public AlphaAlphaModel getGameModel() {
		return gameModel;
	}

	public UcResource getUcResource() {
		return ucResource;
	}

	public UcCosmonaut getUcCosmonaut() {
		return ucCosmonaut;
	}

	public GameController getGameController() {
		return gameController;
	}

	public UcEvent getUcEvent() { return ucEvent; };

	public static void main(String[] args) {
		AlphaAlphaMarsApplication app = new AlphaAlphaMarsApplication();

		//do some configuration before starting the app
		app.setShowSettings(false);
		app.setDisplayFps(false);
		app.setDisplayStatView(false);

		//constructor true means -> keep default settings plus specified custom settings
		AppSettings mySettings = new AppSettings(true);
		mySettings.setResolution(1600, 900);

		app.setSettings(mySettings);
		app.settings.setAudioRenderer(null);

		//app.gameModel = new AlphaAlphaModel(100);
		app.start(); // start the game

	}


	@Override
	public void simpleInitApp() {

		doConfigurationAndBindung();
		initStates();

	}

	private final ActionListener actionListener = new ActionListener() {
		public void onAction(String name, boolean keyPressed, float tpf) {
			if (name.equals("F1") && !keyPressed) {
				stateManager.getState(AlphaAlphaState.class).setEnabled(true);
				stateManager.getState(ImageTestState.class).setEnabled(false);
				stateManager.getState(MarsLandingStartScreen.class).setEnabled(false);
			}
			if (name.equals("F2") && !keyPressed) {
				stateManager.getState(AlphaAlphaState.class).setEnabled(false);
				stateManager.getState(ImageTestState.class).setEnabled(true);
				stateManager.getState(MarsLandingStartScreen.class).setEnabled(false);
			}
			if (name.equals("F3") && !keyPressed) {
				stateManager.getState(AlphaAlphaState.class).setEnabled(false);
				stateManager.getState(ImageTestState.class).setEnabled(false);
				stateManager.getState(MarsLandingStartScreen.class).setEnabled(true);
			}
		}
	};

	private void doConfigurationAndBindung() {

		//configuration
		flyCam.setEnabled(false);

		//this is adding a location
		assetManager.registerLocator(System.getProperty("user.dir") + "/src/rsc/pictures/", FileLocator.class);
		assetManager.registerLocator(System.getProperty("user.dir") + "/src/rsc/nifty/", FileLocator.class);

		//add controller
		this.gameModel = new AlphaAlphaModel();
		this.ucResource = new UcResource(this.getGameModel());
		this.ucCosmonaut = new UcCosmonaut();
		this.ucEvent = new UcEvent();

		this.gameController = new GameController(this.getGameModel());
		this.viewController = new ViewController(this.getGameModel());

		//binding keys
		inputManager.addMapping("F1", new KeyTrigger(KeyInput.KEY_F1));
		inputManager.addMapping("F2", new KeyTrigger(KeyInput.KEY_F2));
		inputManager.addMapping("F3", new KeyTrigger(KeyInput.KEY_F3));

		inputManager.addListener(actionListener, new String[]{"F1", "F2", "F3"});
	}

	private void initStates() {
		stateManager.attachAll(Arrays.asList(new MarsLandingStartScreen(), new ImageTestState(), new AlphaAlphaState()));
		//default
		stateManager.getState(ImageTestState.class).setEnabled(true);
		stateManager.getState(AlphaAlphaState.class).setEnabled(false);
		stateManager.getState(MarsLandingStartScreen.class).setEnabled(false);
	}
}
