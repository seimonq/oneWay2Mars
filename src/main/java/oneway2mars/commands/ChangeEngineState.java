package oneway2mars.commands;

import de.lessvoid.nifty.controls.ConsoleCommands;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;

import java.util.Optional;
import java.util.Set;

public class ChangeEngineState extends AbstractCommand implements ConsoleCommands.ConsoleCommand {

    public ChangeEngineState(AlphaAlphaModel model) {
        super(model);
    }

    @Override
    public void execute(final String[] args) {

        if (args.length != 3) {
            return;
        }

        Optional<Engine> engine = findEngineByName(model.getEngines(), args[1]);
        if (engine.isPresent()) {
            engine.get().setActive(Boolean.parseBoolean(args[2]));
        }

    }

    private Optional<Engine> findEngineByName(Set<Engine> engines, String searchName) {
        return engines.stream().filter( eng -> eng.getName().equals(searchName)).findFirst();
    }
}
