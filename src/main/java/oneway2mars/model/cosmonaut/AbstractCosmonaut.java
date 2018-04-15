package oneway2mars.model.cosmonaut;

import oneway2mars.model.activity.Activity;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;

import java.util.List;
import java.util.Set;

public abstract class AbstractCosmonaut implements Cosmonaut {

	private Set<Health> healthSet;
	private List<Need> needSet;
	private boolean alive;
	private Activity lastActivity;
	private Activity currentActivity;

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
	public void updateNeeds() {
		needSet.forEach( need -> need.updateUrgency(need.getUrgencyRate()));
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
}
