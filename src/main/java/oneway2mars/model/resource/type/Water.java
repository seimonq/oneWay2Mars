package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractAccumulableResource;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.util.commands.constants.InitialGameConstants;

public class Water extends AbstractAccumulableResource implements AccumulableResource {

	public Water() {
		setAmount(InitialGameConstants.WATER_INIT_AMOUNT);
		setAmount(InitialGameConstants.WATER_INIT_AMOUNT_MAX);
	}
}
