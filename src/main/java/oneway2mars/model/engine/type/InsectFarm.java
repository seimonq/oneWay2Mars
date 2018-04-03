package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.Resource;
import oneway2mars.model.resource.type.Energy;
import oneway2mars.model.resource.type.Food;
import oneway2mars.model.resource.type.Water;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.HashMap;
import java.util.Map;

public class InsectFarm extends AbstractEngine implements Engine {

	public InsectFarm() {

		setName("insectfarm");
		setCondition(InitialGameConstants.DEFAULT_CONDITION);
		setConsumerMap(new HashMap<Class<? extends Resource>, Float>() {
			{
				put(Energy.class, InitialGameConstants.INSECT_FARM_CONS_RATE);
			}
		});
		setProducerMap(new HashMap<Class<? extends Resource>, Float>(){
			{
				put(Food.class, InitialGameConstants.INSECT_FARM_PROD_RATE);
			}
		});

		setActive(true);

	}

}
