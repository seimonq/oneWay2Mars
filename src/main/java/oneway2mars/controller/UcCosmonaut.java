package oneway2mars.controller;

import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.resource.Resource;

import java.util.Set;

public class UcCosmonaut {

	public void satisfyNeeds(Set<Cosmonaut> cosmonauts, Set<Resource> resources) {

		updateNeeds(cosmonauts);

		cosmonauts.stream().filter(cos -> cos.isAlive()).forEach(cos -> cos.getNeedSet().stream()
				.filter(
						need -> need.getUrgency() == 1.0f).forEach(
						need -> {
							Float neededAmount = need.getNeededResource().getValue();

							Resource resource = resources.stream().filter(res -> res.getClass()
									.equals(need.getNeededResource().getKey()))
									.findFirst().get();
							if (resource.inStock(neededAmount)) {
								resource.setAmount(resource.getAmount() - neededAmount);
								cos.getHealthSet().forEach(health -> health.satisfy(need.getSatisfactionMap()));
								need.setUrgency(0.0f);
							} else {
								cos.getHealthSet().forEach(health -> health.dissatisfy(need
										.getSatisfactionMap()));
							}
						}));
	}

	public void calcRiskOfDeath(Set<Cosmonaut> cosmonauts) {
		cosmonauts.forEach(cos -> {
			if (cos.getHealthSet().stream().anyMatch(health -> health.getHealthState() < 0.01f)) {
				cos.setAlive(false);
			}
		});
	}

	private void updateNeeds(Set<Cosmonaut> cosmonauts) {
		cosmonauts.forEach(cos -> cos.updateNeeds());
	}
}
