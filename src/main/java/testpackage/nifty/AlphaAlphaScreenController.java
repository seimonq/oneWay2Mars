package testpackage.nifty;

import com.jme3.app.Application;
import com.jme3.app.state.BaseAppState;
import com.jme3.niftygui.NiftyJmeDisplay;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Console;
import de.lessvoid.nifty.controls.ConsoleCommands;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import testpackage.AlphaAlphaMarsApplication;
import testpackage.commands.Eat;

public class AlphaAlphaScreenController extends BaseAppState implements ScreenController {

    private Nifty nifty;
    private Screen screen;
    private AlphaAlphaMarsApplication app;
    private NiftyJmeDisplay niftyDisplay;
    private Console console;

    public AlphaAlphaScreenController() {};
    public AlphaAlphaScreenController(Application app) {
        this.app = (AlphaAlphaMarsApplication) app;

    }

    /**
     * this method is executed after the state is initialized from simpleInitApp()
     * it is important to pass the application instance to the actual controller of the xml file
     * screen methods cannot access game data otherwise
     * @param application
     */
    @Override
    public void initialize(Application application) {
        this.app = (AlphaAlphaMarsApplication) application;
        niftyDisplay = NiftyJmeDisplay.newNiftyJmeDisplay(
                app.getAssetManager(), app.getInputManager(), app.getAudioRenderer(), app.getGuiViewPort());
        nifty = niftyDisplay.getNifty();
        nifty.fromXml("alphaAlphaScreen.xml", "alphaAlphaScreen",new AlphaAlphaScreenController(this.app));
    }

    @Override
    public void update(float tpf) {
        //TODO: implement behavior during runtime
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

    }

    public void bind(Nifty nifty, Screen screen) {
        this.nifty = nifty;
        this.screen = screen;

        this.console = screen.findNiftyControl("consoleAlpha", Console.class);

    }

    public void onStartScreen() {

        console.output("Hello :)");
        ConsoleCommands consoleCommands = new ConsoleCommands(nifty, console);

        // create a simple command (see below for implementation) this class will be called when the command is detected
        // and register the command as a command with the console
        ConsoleCommands.ConsoleCommand eat = new Eat(app.getGameModel(), screen);
        consoleCommands.registerCommand("eat", eat);

        consoleCommands.enableCommandCompletion(true);
    }

    public void onEndScreen() {
        //throw new UnsupportedOperationException("Not supported yet.");
    }


}
