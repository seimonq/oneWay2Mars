package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.Water;
import oneway2mars.util.constants.InitialGameConstants;

public class WaterTreatment extends AbstractEngine implements Engine {

	public WaterTreatment() {

		setName("watertreatment");
//		setCondition(InitialGameConstants.DEFAULT_CONDITION);
//		setConsumerType(Energy.class);
//		setProducerType(Water.class);
//		setConsumationRate(InitialGameConstants.WATER_TREATMENT_CONS_RATE);
//		setProductionRate(InitialGameConstants.WATER_TREATMENT_PROD_RATE);
		setActive(false);

	}
}
