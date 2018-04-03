package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.Oxigen;
import oneway2mars.util.constants.InitialGameConstants;

public class OxigenGenerator extends AbstractEngine implements Engine {

	public OxigenGenerator() {

//		setName("oxigengenerator");
//		setCondition(InitialGameConstants.DEFAULT_CONDITION);
//		setConsumerType(Energy.class);
//		setProducerType(Oxigen.class);
//		setConsumationRate(InitialGameConstants.OXIGEN_GENERATOR_CONS_RATE);
//		setProductionRate(InitialGameConstants.OXIGEN_GENERATOR_PROD_RATE);
		setActive(false);

	}
}
