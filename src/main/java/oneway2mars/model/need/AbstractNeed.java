package oneway2mars.model.need;

import javafx.util.Pair;
import oneway2mars.model.health.Health;

import java.util.Map;

public abstract class AbstractNeed implements Need {
	@Override
	public Float getUrgency() {
		return null;
	}

	@Override
	public void setUrgency(Float urgency) {

	}

	@Override
	public Float getUrgencyRaiseFactor() {
		return null;
	}

	@Override
	public void setUrgencyRaiseFactor() {

	}

	@Override
	public Map<Class<? extends Health>, Pair<Float, Float>> getSatisfactionMap() {
		return null;
	}

	@Override
	public void setSatisfactionMap(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap) {

	}
}
