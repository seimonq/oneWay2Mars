package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.NoResource;
import oneway2mars.util.constants.InitialGameConstants;

public class NuclearReactor extends AbstractEngine implements Engine {

	public NuclearReactor() {

		setName("reactor");
		setCondition(InitialGameConstants.DEFAULT_CONDITION);
		setConsumerType(NoResource.class);
		setProducerType(Energy.class);
		setProductionRate(InitialGameConstants.NUCLEAR_REACTOR_PROD_RATE);
		setActive(true);

	}

}
