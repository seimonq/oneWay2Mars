package oneway2mars.controller;

import oneway2mars.model.activity.Activity;
import oneway2mars.model.activity.type.DoNothing;
import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UcCosmonaut {

	//todo refactor need need to be satisfied by activity
	// need -> urgency -> activity -> reduce urgency, if urgency dissatisfied -> health--
	// if satisfied health++
	public void updateCosmonautState(Set<Cosmonaut> cosmonauts, Set<Resource> resources) {

		Set<Cosmonaut> livingCosmonauts = cosmonauts.stream().filter( c -> c.isAlive()).collect
				(Collectors.toSet());

		livingCosmonauts.forEach(cos -> {
			cos.updateNeeds();
			cos.updateActivity();

			processActivity(cos,resources);
		});



	}

	private void processActivity(Cosmonaut cosmonaut, Set<Resource> resources) {
		Activity currentActivity = cosmonaut.getCurrentActivity();
		currentActivity.getConsumerMap().forEach((resClass, amount) -> {
			Resource consumedRes = resources.stream().filter( res -> res.getClass().equals
					(resClass)).findFirst().get();

			if (consumedRes.inStock(amount)) {
				//set saturation factor
				currentActivity.setSaturationFactor(currentActivity.getSaturationFactor() *
						consumedRes.getAmount() / amount);

				// consume resource
				//todo check on null (amount)
				consumedRes.setAmount(consumedRes.getAmount() - amount);

				//todo with saturation factor (bad, if factor < 1) apply health effect
				cosmonaut.getCurrentActivity().getHealthEffectMap().forEach((healthClass, effect)
						-> {
					Health health = cosmonaut.getHealthSet().stream().filter(hea -> hea.getClass()
							.equals(healthClass)).findFirst().get();
					health.setHealthState(health.getHealthState() + effect.getPositive());
				});

				//todo satisfy need

			}


		});
	}
	
	public void calcRiskOfDeath(Set<Cosmonaut> cosmonauts) {
		cosmonauts.forEach(cos -> {
			if (cos.getHealthSet().stream().anyMatch(health -> health.getHealthState() < 0.01f)) {
				cos.setAlive(false);
			}
		});
	}

}
