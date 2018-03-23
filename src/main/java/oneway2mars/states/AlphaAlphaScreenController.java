package oneway2mars.states;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Console;
import de.lessvoid.nifty.controls.ConsoleCommands;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.elements.render.TextRenderer;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.commands.Eat;
import oneway2mars.controller.CommandController;
import oneway2mars.controller.GameController;
import oneway2mars.controller.ResourceController;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.Resource;

public class AlphaAlphaScreenController extends BaseAppState implements ScreenController {

    private static final Integer PULSE = 2500;
    private Nifty nifty;
    private Screen screen;
    private AlphaAlphaMarsApplication app;
    private NiftyJmeDisplay niftyDisplay;
    private Integer heartBeat;
    private CommandController commandController;

    public AlphaAlphaScreenController() {
    }

    ;

    public AlphaAlphaScreenController(Application app) {
        this.app = (AlphaAlphaMarsApplication) app;

    }

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
            app.getResourceController().updateResources(app.getGameModel());

            String consumingRes = app.getGameModel().getEngines().get(0).getConsumerType().getSimpleName();
            String producingRes = app.getGameModel().getEngines().get(0).getProducerType().getSimpleName();

            Element outputField = nifty.getCurrentScreen().findElementById("outputBody");
            outputField.getRenderer(TextRenderer.class).setText(consumingRes + ": " + app.getGameModel().getResources().get(0)
                    .getAmount().toString() + ", " + producingRes + ": " + app.getGameModel().getResources().get(1).getAmount().toString());

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

    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;
        this.commandController = new CommandController();

    }

    public void onStartScreen() {

        Console console = screen.findNiftyControl("consoleAlpha", Console.class);

        console.output("Hello :)");
        commandController.registerCommands(nifty, console, screen, app);
    }

    public void onEndScreen() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


}
