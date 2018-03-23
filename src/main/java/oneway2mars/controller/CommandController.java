package oneway2mars.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Console;
import de.lessvoid.nifty.controls.ConsoleCommands;
import de.lessvoid.nifty.screen.Screen;
import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.commands.Eat;

public class CommandController {

    public void registerCommands(Nifty nifty, Console console, Screen screen, AlphaAlphaMarsApplication app) {


        ConsoleCommands consoleCommands = new ConsoleCommands(nifty, console);

        // create a simple command (see below for implementation) this class will be called when the command is detected
        // and register the command as a command with the console
        ConsoleCommands.ConsoleCommand eat = new Eat(app.getGameModel(), screen);
        consoleCommands.registerCommand("eat", eat);

        consoleCommands.enableCommandCompletion(true);
    }
}
