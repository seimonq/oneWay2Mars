package oneway2mars.model.need.type;

import javafx.util.Pair;
import oneway2mars.model.health.Health;
import oneway2mars.model.need.AbstractNeed;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.HashMap;

public class Hunger extends AbstractNeed {

	public Hunger() {
		setUrgency(0f);
		setUrgencyRate(InitialGameConstants.NEED_HUNGER_URGENCY_RATE);

		setNeededResource(InitialGameConstants.NEED_HUNGER_RESOURCE_FOOD);

		setSatisfactionMap(new HashMap<Class<? extends Health>, Pair<Float, Float>>() {{
			put(Health.class, InitialGameConstants.NEED_HUNGER_SATISFACTION_HEALTH_PHYSICAL);
		}});

	}
}
