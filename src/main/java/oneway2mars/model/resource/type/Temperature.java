package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractAccumulableResource;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.util.commands.constants.InitialGameConstants;

public class Temperature extends AbstractAccumulableResource implements AccumulableResource {

	public Temperature() {
		setAmount(InitialGameConstants.TEMPERATURE_INIT_AMOUNT);

	}
}
