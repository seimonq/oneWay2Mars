package oneway2mars.controller;

import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.engine.InsectFarm;
import oneway2mars.model.resource.FusionFuel;
import oneway2mars.model.resource.MealWorms;
import oneway2mars.model.resource.Resource;

import java.util.Arrays;

public class GameController {
    private AlphaAlphaMarsApplication app;

    public GameController(AlphaAlphaMarsApplication app) {
        this.app = app;
    }

    public void initGame() {

        Resource worms = new MealWorms();
        worms.setAmount(50f);
        Resource fuel = new FusionFuel();
        fuel.setAmount(200f);
        app.getGameModel().setResources(Arrays.asList(fuel, worms));

        Engine insectFarm = new InsectFarm();
        app.getGameModel().setEngines(Arrays.asList(insectFarm));

    }
}
