package oneway2mars.controller;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;

import java.util.List;
import java.util.stream.Collectors;

public class UcResource {

	private AlphaAlphaModel model;

	public UcResource(AlphaAlphaModel model) {
		this.model = model;
	}

	public void updateResources(AlphaAlphaModel model) {

		List<Engine> workingEngines = model.getEngines().stream().filter(eng -> eng.isActivated
				()).collect(Collectors.toList());

		model.getEngines().forEach(eng -> eng.shiftToNextTick());

		model.getResources().forEach(res -> {
			res.shiftToNextTick();
			res.calcConsumedNow(workingEngines);
		});

		workingEngines.forEach(eng -> eng.calcEfficiency());

		model.getResources().forEach(res -> {
			res.calcProducedNow(workingEngines);
			res.calcAmountAfterTick();
		});
	}

}
