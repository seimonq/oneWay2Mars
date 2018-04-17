package oneway2mars.model.cosmonaut.health;

import javafx.util.Pair;

import java.util.Map;

public abstract class AbstractHealth implements Health {

	private Float healthState;
	private Float riskOfDeath;
	@Override
	public Float getHealthState() {
		return healthState;
	}

	@Override
	public void setHealthState(Float healthState) {
		this.healthState = healthState;
	}

	@Override
	public Float getRiskOfDeathFactor() {
		return riskOfDeath;
	}

	@Override
	public void setRiskOfDeathFactor(Float riskOfDeath) {
		this.riskOfDeath = riskOfDeath;
	}

	@Override
	public void satisfy(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap) {

		if(satisfactionMap.containsKey(this.getClass())) {
			healthState += satisfactionMap.get(this.getClass()).getKey();
			if(healthState > 1.0f) {
				healthState = 1.0f;
			}
		}
	}

	@Override
	public void dissatisfy(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap) {
		if(satisfactionMap.containsKey(this.getClass())) {
			healthState -= satisfactionMap.get(this.getClass()).getValue();
			if(healthState < 0.0f) {
				healthState = 0.0f;
			}
		}
	}

	@Override
	public void add(Float addHealth) {
		healthState += addHealth;
		healthState = (healthState > 1f ? 1f : healthState);
		healthState = (healthState < 0f ? 0f : healthState);
	}

}
