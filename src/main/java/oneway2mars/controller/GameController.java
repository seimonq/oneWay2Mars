package oneway2mars.controller;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.cosmonaut.type.Siegmund;
import oneway2mars.model.engine.type.*;
import oneway2mars.model.health.type.PhysicalHealth;
import oneway2mars.model.need.type.Hunger;
import oneway2mars.model.resource.type.*;

import java.util.Arrays;
import java.util.HashSet;

public class GameController {
	private AlphaAlphaModel model;

	public GameController(AlphaAlphaModel model) {
		this.model = model;
	}

	public void initGame() {

		model.setResources(new HashSet<>(Arrays.asList(new Energy(), new Food(), new Ore(), new Oxigen(),
				new Temperature(), new Water())));

		model.setEngines(new HashSet<>(Arrays.asList(new AirConditioner(), new InsectFarm(), new NuclearReactor
				(), new OxigenGenerator(), new Rover(), new WaterTreatment())));

		Cosmonaut siegmund = new Siegmund();
		siegmund.setHealthSet(new HashSet<>(Arrays.asList(new PhysicalHealth())));
		siegmund.setNeedSet(new HashSet<>(Arrays.asList(new Hunger())));

		model.setCosmonauts(new HashSet<>(Arrays.asList(siegmund)));


	}
}
