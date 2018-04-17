package oneway2mars.model.cosmonaut;

import oneway2mars.model.activity.Activity;
import oneway2mars.model.activity.type.DoNothing;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.List;
import java.util.Set;

public abstract class AbstractCosmonaut implements Cosmonaut {

	private Set<Health> healthSet;
	private List<Need> needSet;
	private boolean alive;
	private Activity lastActivity;
	private Activity currentActivity;
	private Set<Activity> availableActivities;


	@Override
	public Set<Health> getHealthSet() {
		return healthSet;
	}

	@Override
	public void setHealthSet(Set<Health> healthSet) {
		this.healthSet = healthSet;
	}

	@Override
	public List<Need> getNeeds() {
		return needSet;
	}

	@Override
	public void setNeeds(List<Need> needSet) {
		this.needSet = needSet;
	}

	@Override
	public boolean isAlive() {
		return alive;
	}

	@Override
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public void shiftToNextTick() {
		needSet.forEach(need -> need.updateUrgency(need.getUrgencyRate()));
		getCurrentActivity().setSaturation(1f);
	}

	@Override
	public Activity getLastActivity() {
		return this.lastActivity;
	}

	@Override
	public void setLastActivity(Activity activity) {
		this.lastActivity = activity;
	}

	@Override
	public Activity getCurrentActivity() {
		return currentActivity;
	}

	@Override
	public void setCurrentActivity(Activity activity) {
		this.currentActivity = activity;
	}

	@Override
	public Set<Activity> getAvailableActivities() {
		return availableActivities;
	}

	@Override
	public void setAvailableActivities(Set<Activity> availableActivities) {
		this.availableActivities = availableActivities;
	}

	@Override
	public void processActivity(Set<Resource> resources) {
		//todo remove
	}

	@Override
	public void updateActivity() {
		//todo remove
	}


}
