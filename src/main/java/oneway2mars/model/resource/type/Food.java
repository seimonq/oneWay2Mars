package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractAccumulableResource;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.util.constants.InitialGameConstants;

public class Food extends AbstractAccumulableResource implements AccumulableResource {

	public Food() {
		setAmount(InitialGameConstants.FOOD_INIT_AMOUNT);
		setMaxstorableAmount(InitialGameConstants.FOOD_INIT_AMOUNT_MAX);
	}
}
