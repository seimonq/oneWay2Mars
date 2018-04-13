package oneway2mars.commands;

import de.lessvoid.nifty.controls.ConsoleCommands;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.event.Decision;

import java.util.Optional;

public class Wahl extends AbstractCommand implements ConsoleCommands.ConsoleCommand {

	public Wahl(AlphaAlphaModel model) {
		super(model);
	}

	@Override
	public void execute(final String[] args) {

		if (args.length != 2) {
			System.out.println("more or less then one argument");
			return;
		}
		if(!model.getEventAwaitsDecision().isPresent()) {
			System.out.println("No Event awaits any decision");
			return;
		}
		if(args[1].equals("ja")) {
			model.getEventAwaitsDecision().get().setDecision(Decision.ACCEPTED);
			model.setEventAwaitsDecision(Optional.empty());
		}
		else if(args[1].equals("nein")) {
			model.getEventAwaitsDecision().get().setDecision(Decision.DENIED);
			model.setEventAwaitsDecision(Optional.empty());
		}
	}

}
