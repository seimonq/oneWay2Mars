package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.Temperature;
import oneway2mars.util.constants.InitialGameConstants;

public class AirConditioner extends AbstractEngine implements Engine {

	public AirConditioner() {

		setName("airconditioner");
//		setCondition(InitialGameConstants.DEFAULT_CONDITION);
//		setConsumerType(Energy.class);
//		setProducerType(Temperature.class);
//		setConsumationRate(InitialGameConstants.AIR_CONDITIONER_CONS_RATE);
//		setProductionRate(InitialGameConstants.AIR_CONDITIONER_PROD_RATE);
		setActive(false);

	}
}
