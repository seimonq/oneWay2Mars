package oneway2mars.model.engine;

import oneway2mars.model.resource.Food;
import oneway2mars.model.resource.Water;

public class InsectFarm extends AbstractEngine implements Engine {

    public InsectFarm(String name, Float consumationRate, Float productionRate) {

        super(name,consumationRate,productionRate);
        consumerType = Water.class;
        producerType = Food.class;

    }

}
