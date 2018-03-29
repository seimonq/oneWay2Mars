package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractNonAccumulableResource;
import oneway2mars.model.resource.NonAccumulableResource;
import oneway2mars.util.commands.constants.InitialGameConstants;

public class Energy extends AbstractNonAccumulableResource implements NonAccumulableResource {

    public Energy() {
        setAmount(InitialGameConstants.ENERGY_INIT_AMOUNT);
        setUnusedAmount(InitialGameConstants.ENERGY_INIT_AMOUNT);
    }
}
