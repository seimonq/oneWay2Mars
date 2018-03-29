package oneway2mars.controller;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.engine.type.*;
import oneway2mars.model.resource.type.*;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.commands.constants.InitialGameConstants;

import java.util.Arrays;

public class GameController {
    private AlphaAlphaModel model;

    public GameController(AlphaAlphaModel model) {
        this.model = model;
    }

    public void initGame() {

        model.setResources(Arrays.asList(new Energy(), new Food(), new Ore(), new Oxigen(), new
                Temperature(), new Water()));

        model.setEngines(Arrays.asList(new AirConditioner(), new InsectFarm(), new NuclearReactor
                (), new OxigenGenerator(), new Rover(), new WaterTreatment()));

    }
}
