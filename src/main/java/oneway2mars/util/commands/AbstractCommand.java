package oneway2mars.util.commands;

import oneway2mars.model.AlphaAlphaModel;

public abstract class AbstractCommand {

    protected AlphaAlphaModel model;

    public AbstractCommand() {}

    public AbstractCommand (AlphaAlphaModel model) {
        this.model = model;
    }
}
