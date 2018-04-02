package oneway2mars.model.engine.type;

import oneway2mars.model.engine.AbstractEngine;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.type.Food;
import oneway2mars.model.resource.type.Water;
import oneway2mars.util.constants.InitialGameConstants;

public class InsectFarm extends AbstractEngine implements Engine {

    public InsectFarm() {

        setName("insectfarm");
        setCondition(InitialGameConstants.DEFAULT_CONDITION);
        setConsumerType(Water.class);
        setProducerType(Food.class);
        setConsumationRate(InitialGameConstants.INSECT_FARM_CONS_RATE);
        setProductionRate(InitialGameConstants.INSECT_FARM_PROD_RATE);
        setActive(true);

    }

}
