package oneway2mars.controller;

import oneway2mars.model.activity.Activity;
import oneway2mars.model.activity.type.DoNothing;
import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.constants.InitialGameConstants;
import oneway2mars.util.methods.MarsUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UcCosmonaut {

	/**
	 * handles and processes activities, needs and health of
	 * {@link Cosmonaut} each tick
	 *
	 * @param cosmonauts
	 * @param resources
	 * @param currentTick
	 */
	public void updateCosmonautState(Set<Cosmonaut> cosmonauts, Set<Resource> resources, Long
			currentTick) {

		Set<Cosmonaut> livingCosmonauts = cosmonauts.stream().filter( c -> c.isAlive()).collect
				(Collectors.toSet());

		livingCosmonauts.forEach(cos -> {
			cos.shiftToNextTick();
			changeOrContinueActivity(cos,currentTick);
			applyActivityEffects(cos,resources);
			calcRiskOfDeath(cos);
		});



	}


	private void calcRiskOfDeath(Cosmonaut cosmonaut) {
			if (cosmonaut.getHealthSet().stream().anyMatch(health -> health.getHealthState() < 0.01f)) {
				cosmonaut.setAlive(false);
			}
	}

	private void changeOrContinueActivity(Cosmonaut cosmonaut, Long currentTick) {
		if (cosmonaut.getCurrentActivity() == null || !cosmonaut.getCurrentActivity()
				.continueActivity(currentTick)) {
			cosmonaut.setLastActivity(cosmonaut.getCurrentActivity());
			cosmonaut.setCurrentActivity(findNextActivity(cosmonaut.getNeeds(), cosmonaut.getAvailableActivities()));
			cosmonaut.getCurrentActivity().startActivity(currentTick);
		}
	}

	private void applyActivityEffects(Cosmonaut cosmonaut, Set<Resource> resources) {

		updateResourcesOnActivity(cosmonaut,resources);
		applyHealthEffectOnActivity(cosmonaut);
		reduceUrgencyOnActivity(cosmonaut);

	}
	private void updateResourcesOnActivity(Cosmonaut cosmonaut, Set<Resource> resources) {
		Activity currentActivity = cosmonaut.getCurrentActivity();

		currentActivity.getConsumerMap().forEach((resClass, amount) -> {
			Float saturationForConsumedResource = consumeResource(MarsUtils.findElementByClass(resources,
					resClass), amount);
			currentActivity.multiplySaturationBy(saturationForConsumedResource);
		});
	}
	private void applyHealthEffectOnActivity(Cosmonaut cosmonaut) {
		Activity currentActivity = cosmonaut.getCurrentActivity();

		currentActivity.getHealthEffectMap().forEach((healthClass, effect) -> {
			if(currentActivity.getSaturation() == 1f) {
				applyHealthEffects(MarsUtils.findElementByClass(cosmonaut.getHealthSet(),
						healthClass),effect.getPositive());
			} else {
				applyHealthEffects(MarsUtils.findElementByClass(cosmonaut.getHealthSet(),
						healthClass),effect.getNegative());
			}
		});
	}
	private void reduceUrgencyOnActivity(Cosmonaut cosmonaut) {
		Activity currentActivity = cosmonaut.getCurrentActivity();

		if(currentActivity.getSaturation() == 1f) {
			reduceUrgency(MarsUtils.findElementByClass(cosmonaut.getNeeds(),currentActivity
					.getSatisfiedNeed().getKey()), currentActivity.getSatisfiedNeed().getValue());
		}
	}
	private Float consumeResource(Resource consumedResource, Float amount) {

		if (consumedResource.inStock(amount)) {
			// consume resource
			consumedResource.add(-amount);
			return 1f;
		} else {
			Float saturation = consumedResource.getAmount() / amount;
			consumedResource.setAmount(0f);
			return saturation;
		}
	}
	private void applyHealthEffects(Health health, Float amount) {
		health.add(amount);
	}

	private void reduceUrgency(Need need, Float amountReduced) {
		need.addUrgency(amountReduced);
	}

	private Activity findNextActivity(List<Need> needs, Set<Activity> activities) {

		Activity newActivity = new DoNothing();
			//if no needs are urgent enough the cosmonaut does nothing so far
		for (Need need : needs) {
			if (need.getUrgency() > InitialGameConstants.NEED_SATISFACTION_THRESHOLD) {

				newActivity = activities.stream().filter(activity -> activity.getSatisfiedNeed()
						.getKey().equals(need.getClass())).findFirst().get();
			}
		}

		return newActivity;
	}
}
