package oneway2mars.controller;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.AirConditioner;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.engine.InsectFarm;
import oneway2mars.model.resource.Energy;
import oneway2mars.model.resource.Food;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.commands.constants.InitialGameConstants;

import java.util.Arrays;

public class GameController {
    private AlphaAlphaModel model;

    public GameController(AlphaAlphaModel model) {
        this.model = model;
    }

    public void initGame() {

        Resource worms = new Food();
        worms.setAmount(50f);
        Resource fuel = new Energy();
        fuel.setAmount(200f);
        model.setResources(Arrays.asList(fuel, worms));

      //  Engine airCondition = new AirConditioner("airCondition", InitialGameConstants.AIR_CONDITIONER_CONS_RATE, InitialGameConstants.AIR_CONDITIONER_PROD_RATE);
        Engine insectFarm = new InsectFarm("insectfarm", InitialGameConstants.INSECT_FARM_CONS_RATE, InitialGameConstants.INSECT_FARM_PROD_RATE);
      //  Engine
        model.setEngines(Arrays.asList(insectFarm));

    }
}
