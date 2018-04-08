package oneway2mars.model.cosmonaut;

import oneway2mars.model.health.Health;
import oneway2mars.model.need.Need;

import java.util.Set;

public abstract class AbstractCosmonaut implements Cosmonaut {

	private Set<Health> healthSet;
	private Set<Need> needSet;
	private boolean alive;

	@Override
	public Set<Health> getHealthSet() {
		return healthSet;
	}

	@Override
	public void setHealthSet(Set<Health> healthSet) {
		this.healthSet = healthSet;
	}

	@Override
	public Set<Need> getNeedSet() {
		return needSet;
	}

	@Override
	public void setNeedSet(Set<Need> needSet) {
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
}
