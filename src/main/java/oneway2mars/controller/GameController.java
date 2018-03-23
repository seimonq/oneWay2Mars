package oneway2mars.controller;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.engine.InsectFarm;
import oneway2mars.model.resource.FusionFuel;
import oneway2mars.model.resource.MealWorms;
import oneway2mars.model.resource.Resource;

import java.util.Arrays;

public class GameController {
    private AlphaAlphaModel model;

    public GameController(AlphaAlphaModel model) {
        this.model = model;
    }

    public void initGame() {

        Resource worms = new MealWorms();
        worms.setAmount(50f);
        Resource fuel = new FusionFuel();
        fuel.setAmount(200f);
        model.setResources(Arrays.asList(fuel, worms));

        Engine insectFarm = new InsectFarm("insectfarm", -1f, 2f);
        model.setEngines(Arrays.asList(insectFarm));

    }
}
