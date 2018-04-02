package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.Ore;
import oneway2mars.util.constants.InitialGameConstants;

public class Rover extends AbstractEngine implements Engine {

	public Rover() {

		setName("rover");
		setCondition(InitialGameConstants.DEFAULT_CONDITION);
		setConsumerType(Energy.class);
		setProducerType(Ore.class);
		setConsumationRate(InitialGameConstants.ROVER_CONS_RATE);
		setProductionRate(InitialGameConstants.ROVER_PROD_RATE);
		setActive(false);

	}
}
