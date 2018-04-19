package oneway2mars.model.cosmonaut.need.type;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.health.type.PhysicalHealth;
import oneway2mars.model.cosmonaut.need.AbstractNeed;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.HashMap;

public class Hunger extends AbstractNeed implements Need {

	public Hunger() {
		setUrgency(0f);
		setUrgencyRate(InitialGameConstants.NEED_HUNGER_URGENCY_RATE);
		setHealthPenaltyMap(InitialGameConstants.NEED_HUNGER_HEALTH_PENALTY_MAP);

	}
}
