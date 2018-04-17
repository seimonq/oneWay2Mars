package oneway2mars.model.cosmonaut.need;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.resource.Resource;

import java.util.Map;

public abstract class AbstractNeed implements Need {

	private Float urgency;
	private Float urgencyRate;
	private Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap;
	private Pair<Class<? extends Resource>, Float> neededResource;

	@Override
	public Pair<Class<? extends Resource>, Float> getNeededResource() {
		return neededResource;
	}

	public void setNeededResource(Pair<Class<? extends Resource>, Float> neededResource) {
		this.neededResource = neededResource;
	}

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
	public Map<Class<? extends Health>, Pair<Float, Float>> getSatisfactionMap() {
		return satisfactionMap;
	}

	@Override
	public void setSatisfactionMap(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap) {
		this.satisfactionMap = satisfactionMap;
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
