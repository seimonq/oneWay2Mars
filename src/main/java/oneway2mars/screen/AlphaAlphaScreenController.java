package oneway2mars.screen;

import com.jme3.app.Application;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Console;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;
import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.controller.CommandController;

public class AlphaAlphaScreenController implements ScreenController {

    private Nifty nifty;
    private Screen screen;
    private AlphaAlphaMarsApplication app;
    private CommandController commandController;

        //pass a
    public AlphaAlphaScreenController(Application app) {
        this.app = (AlphaAlphaMarsApplication) app;

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
