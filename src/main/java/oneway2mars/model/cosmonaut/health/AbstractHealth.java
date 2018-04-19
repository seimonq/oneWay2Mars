package oneway2mars.model.cosmonaut.health;

import javafx.util.Pair;

import java.util.Map;

public abstract class AbstractHealth implements Health {

	private Float healthState;
	@Override
	public Float getHealthState() {
		return healthState;
	}

	@Override
	public void setHealthState(Float healthState) {
		this.healthState = healthState;
	}

	@Override
	public void add(Float addHealth) {
		healthState += addHealth;
		healthState = (healthState > 1f ? 1f : healthState);
		healthState = (healthState < 0f ? 0f : healthState);
	}

}
