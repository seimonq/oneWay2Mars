package oneway2mars.model.need;

import javafx.util.Pair;
import oneway2mars.model.health.Health;
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
