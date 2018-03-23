package oneway2mars.model.engine;

import oneway2mars.model.resource.FusionFuel;
import oneway2mars.model.resource.MealWorms;
import oneway2mars.model.resource.Resource;

public class InsectFarm extends AbstractEngine implements Engine {


    public InsectFarm() {
        consumerType = FusionFuel.class;
        producerType = MealWorms.class;
        consumationRate = -1f;
        productionRate = 2f;
        setActivated(true);
    }
}
