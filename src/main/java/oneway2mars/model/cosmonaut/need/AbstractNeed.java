package oneway2mars.model.cosmonaut.need;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.resource.Resource;

import java.util.Map;

public abstract class AbstractNeed implements Need {

	private Float urgency;
	private Float urgencyRate;
	private Map<Class<? extends Health>, Float> healthPenaltyMap;

	@Override
	public Float getUrgency() {
		return urgency;
	}

	@Override
	public void setUrgency(Float urgency) {
		this.urgency = urgency;
	}

	@Override
	public void addUrgency(Float amountAdded) {
		urgency += amountAdded;
		urgency = (urgency > 1f ? 1f : urgency);
		urgency = (urgency < 0f ? 0f : urgency);
	}
	@Override
	public Float getUrgencyRate() {
		return urgencyRate;
	}

	@Override
	public void setUrgencyRate(Float urgencyRate) {
		this.urgencyRate = urgencyRate;
	}


	@Override
	public Map<Class<? extends Health>, Float> getHealthPenaltyMap() {
		return healthPenaltyMap;
	}

	@Override
	public void setHealthPenaltyMap(Map<Class<? extends Health>, Float> healthPenaltyMap) {
		this.healthPenaltyMap = healthPenaltyMap;
	}

	@Override
	public void updateUrgency(Float delta) {
		if (delta > 0f) {
			urgency += delta;
			if (urgency > 1.0f) {
				urgency = 1.0f;
			}
		}
	}
}
