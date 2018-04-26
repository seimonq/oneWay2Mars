package oneway2mars.controller;

import oneway2mars.model.cosmonaut.activity.Activity;
import oneway2mars.model.cosmonaut.activity.type.DoNothing;
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

		Set<Cosmonaut> livingCosmonauts = cosmonauts.stream().filter(c -> c.isAlive()).collect
				(Collectors.toSet());

		livingCosmonauts.forEach(cos -> {
			cos.shiftToNextTick();
			updateActivity(cos, currentTick);
			applyActivityEffect(cos, resources);

			applyNeedUrgencyPenalty(cos);
			checkRiskOfDeath(cos);
		});
	}

	private void checkRiskOfDeath(Cosmonaut cosmonaut) {
		if (cosmonaut.getHealthSet().stream().anyMatch(health -> health.getHealthState() < 0.01f)) {
			cosmonaut.setAlive(false);
		}
	}

	private void updateActivity(Cosmonaut cosmonaut, Long currentTick) {
		if (cosmonaut.getCurrentActivity() == null || !cosmonaut.getCurrentActivity()
				.continueActivity(currentTick)) {
			cosmonaut.setLastActivity(cosmonaut.getCurrentActivity());
			cosmonaut.setCurrentActivity(findNextActivity(cosmonaut.getNeeds(), cosmonaut.getAvailableActivities()));

			if (cosmonaut.getCurrentActivity() != null) {
				cosmonaut.getCurrentActivity().startActivity(currentTick);
			}
		}
	}

	private void applyNeedUrgencyPenalty(Cosmonaut cos) {
		for (Need need : cos.getNeeds()) {
			if (need.getUrgency() > InitialGameConstants.NEED_PENALTY_THRESHOLD) {
				need.getHealthPenaltyMap().forEach((healthClass, penalty) -> {
					MarsUtils.findElementByClass(cos.getHealthSet(), healthClass).add(-penalty);
				});
			}
		}
	}

	private void applyActivityEffect(Cosmonaut cosmonaut, Set<Resource> resources) {

		Activity currentActivity = cosmonaut.getCurrentActivity();

		if (currentActivity != null) {
			updateResourcesOnActivity(currentActivity, resources);
			applyHealthEffectOnActivity(currentActivity, cosmonaut);
			reduceUrgencyOnActivity(currentActivity, cosmonaut);
		}
	}

	private void updateResourcesOnActivity(Activity currentActivity, Set<Resource> resources) {

		currentActivity.getConsumerMap().forEach((resClass, amount) -> {
			Float saturationForConsumedResource = consumeResource(MarsUtils.findElementByClass(resources,
					resClass), amount);
			currentActivity.multiplySaturationBy(saturationForConsumedResource);
		});
	}

	private void applyHealthEffectOnActivity(Activity currentActivity, Cosmonaut cosmonaut) {

		if(cosmonaut.getNeeds().stream().filter(need -> need.getUrgency() >= 1.0f).findAny()
				.isPresent()) {
			//do not apply health positive impact
			return;
		}
		currentActivity.getHealthEffectMap().forEach((healthClass, effect) -> {
			applyHealthEffects(MarsUtils.findElementByClass(cosmonaut.getHealthSet(),
					healthClass), effect, currentActivity.getSaturation());

		});
	}

	private void reduceUrgencyOnActivity(Activity currentActivity, Cosmonaut cosmonaut) {
		if (currentActivity.getSaturation() == 1f) {
			reduceUrgency(MarsUtils.findElementByClass(cosmonaut.getNeeds(), currentActivity
							.getSatisfiedNeed().getKey()), currentActivity.getSatisfiedNeed().getValue(),
					currentActivity.getSaturation());
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

	private void applyHealthEffects(Health health, Float amount, Float saturation) {
		health.add(amount * saturation);
	}

	private void reduceUrgency(Need need, Float amountReduced, Float saturation) {
		need.addUrgency(- amountReduced * saturation);
	}

	private Activity findNextActivity(List<Need> needs, Set<Activity> activities) {

		Activity newActivity = null;
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
