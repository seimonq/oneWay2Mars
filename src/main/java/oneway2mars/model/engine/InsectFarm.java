package oneway2mars.model.engine;

import oneway2mars.model.resource.FusionFuel;
import oneway2mars.model.resource.MealWorms;
import oneway2mars.model.resource.Resource;

public class InsectFarm extends AbstractEngine implements Engine {

    public InsectFarm(String name, Float consumationRate, Float productionRate) {
        consumerType = FusionFuel.class;
        producerType = MealWorms.class;
        this.consumationRate = consumationRate;
        this.productionRate = productionRate;
        this.name = name;
        setActive(true);
    }

}
