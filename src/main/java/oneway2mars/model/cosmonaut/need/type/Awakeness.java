package oneway2mars.model.cosmonaut.need.type;

import oneway2mars.model.cosmonaut.need.AbstractNeed;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.util.constants.InitialGameConstants;

public class Awakeness extends AbstractNeed implements Need {

	public Awakeness() {
		setUrgency(0f);
		setUrgencyRate(InitialGameConstants.NEED_AWAKENESS_URGENCY_RATE);
		setHealthPenaltyMap(InitialGameConstants.NEED_AWAKENESS_HEALTH_PENALTY_MAP);

	}
}
