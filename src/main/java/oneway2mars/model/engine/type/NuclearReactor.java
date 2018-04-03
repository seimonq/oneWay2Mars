package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.Resource;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.Food;
import oneway2mars.model.resource.type.NoResource;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.HashMap;

public class NuclearReactor extends AbstractEngine implements Engine {

	public NuclearReactor() {

		setName("reactor");
		setCondition(InitialGameConstants.DEFAULT_CONDITION);

		setConsumerMap(new HashMap<Class<? extends Resource>, Float>() {
			{
				put(NoResource.class, 0f);
			}
		});
		setProducerMap(new HashMap<Class<? extends Resource>, Float>(){
			{
				put(Energy.class, InitialGameConstants.NUCLEAR_REACTOR_PROD_RATE);
			}
		});

		setActive(true);

	}

}
