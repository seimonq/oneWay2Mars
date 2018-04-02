package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractAccumulableResource;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.util.constants.InitialGameConstants;

public class Ore extends AbstractAccumulableResource implements AccumulableResource {

	public Ore() {
		setAmount(InitialGameConstants.ORE_INIT_AMOUNT);
		setAmount(InitialGameConstants.ORE_INIT_AMOUNT_MAX);
	}
}
