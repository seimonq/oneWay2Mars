package oneway2mars.controller;

import oneway2mars.model.activity.Activity;
import oneway2mars.model.activity.type.DoNothing;
import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.List;
import java.util.Set;

public class UcCosmonaut {

	//todo refactor need need to be satisfied by activity
	// need -> urgency -> activity -> reduce urgency, if urgency dissatisfied -> health--
	// if satisfied health++
	public void satisfyNeeds(Set<Cosmonaut> cosmonauts, Set<Resource> resources) {

		updateNeeds(cosmonauts);

		cosmonauts.stream().filter(cos -> cos.isAlive()).forEach(cos -> cos.getNeeds().stream()
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

	public void updateActivity(Set<Cosmonaut> cosmonauts) {

		for( Cosmonaut cosmonaut : cosmonauts) {
			if(cosmonaut.getCurrentActivity() == null || !cosmonaut.getCurrentActivity()
					.continueActivity()) {
				cosmonaut.setLastActivity(cosmonaut.getCurrentActivity());
				cosmonaut.setCurrentActivity(findNextActivity(cosmonaut.getNeeds(),cosmonaut.getAvailableActivities()));
				cosmonaut.getCurrentActivity().startActivity();
			}
			processActivity(cosmonaut.getCurrentActivity());
		}
	}
	private Activity findNextActivity(List<Need> needs, Set<Activity> activities) {
		//todo implement
//		Activity newActivity;
//		for( Need need : needs) {
//			if(need.getUrgency() > InitialGameConstants.NEED_SATISFACTION_THRESHOLD) {
//
//				newActivity = activities.stream().filter( ac -> ac.getSatisfiedNeed().equals(need
//						.getClass())).findAny().get();
//			}
//		}
//	//	newActivity = new DoNothing();
//
//	return newActivity;
	}

	private void processActivity(Activity activity) {
		//todo implement
	}

	private void updateNeeds(Set<Cosmonaut> cosmonauts) {
		cosmonauts.forEach(cos -> cos.updateNeeds());
	}

}
