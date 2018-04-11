package oneway2mars.controller;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Console;
import de.lessvoid.nifty.controls.ConsoleCommands;
import de.lessvoid.nifty.screen.Screen;
import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.util.commands.ChangeEngineState;
import oneway2mars.util.commands.Eat;
import oneway2mars.util.commands.Wahl;

public class UcCommand {

	public void registerCommands(Nifty nifty, Console console, Screen screen, AlphaAlphaMarsApplication app) {


		ConsoleCommands consoleCommands = new ConsoleCommands(nifty, console);

		// create a simple command (see below for implementation) this class will be called when the command is detected
		// and register the command as a command with the console
		ConsoleCommands.ConsoleCommand eat = new Eat(app.getGameModel(), screen);
		consoleCommands.registerCommand("eat", eat);

		//switch engines on/off
		ConsoleCommands.ConsoleCommand switchEngineState = new ChangeEngineState(app.getGameModel());
		consoleCommands.registerCommand("engineactive", switchEngineState);

		//decide something for an event
		ConsoleCommands.ConsoleCommand decideEvent = new Wahl(app.getGameModel());
		consoleCommands.registerCommand("wahl",decideEvent);

		consoleCommands.enableCommandCompletion(true);
	}
}
