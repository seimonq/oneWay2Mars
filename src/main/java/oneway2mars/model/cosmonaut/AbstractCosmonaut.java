package oneway2mars.model.cosmonaut;

import oneway2mars.model.health.Health;
import oneway2mars.model.need.Need;

import java.util.Set;

public abstract class AbstractCosmonaut implements Cosmonaut {
	@Override
	public Set<Class<? extends Health>> getHealthSet() {
		return null;
	}

	@Override
	public void setHealthSet(Set<Class<? extends Health>> healthSet) {

	}

	@Override
	public Set<Class<? extends Need>> getNeedSet() {
		return null;
	}

	@Override
	public void setNeedSet(Set<Class<? extends Need>> needSet) {

	}

	@Override
	public boolean isAlive() {
		return false;
	}

	@Override
	public void setAlive(boolean alive) {

	}
}
