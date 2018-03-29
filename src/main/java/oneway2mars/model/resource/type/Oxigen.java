package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractAccumulableResource;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.util.commands.constants.InitialGameConstants;

public class Oxigen extends AbstractAccumulableResource implements AccumulableResource {

	public Oxigen() {
		setAmount(InitialGameConstants.OXIGEN_INIT_AMOUNT);
		setMaxstorableAmount(InitialGameConstants.OXIGEN_INIT_AMOUNT_MAX);
	}

}
