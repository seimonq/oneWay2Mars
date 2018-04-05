package oneway2mars.states;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.controller.UcCommand;
import oneway2mars.screen.AlphaAlphaScreenController;

public class AlphaAlphaState extends BaseAppState{

    private static final Integer PULSE = 1500;
    private Nifty nifty;
    private Screen screen;
    private AlphaAlphaMarsApplication app;
    private NiftyJmeDisplay niftyDisplay;
    private Integer heartBeat;
    private UcCommand ucCommand;

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
        if (heartBeat == null || heartBeat > PULSE) {
            heartBeat = 1;
        } else {
            heartBeat++;
        }

        if (heartBeat % PULSE == 0) {
            app.getUcResource().updateResources(app.getGameModel());
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
}
