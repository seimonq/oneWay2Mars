package oneway2mars.model.cosmonaut.health.type;

import oneway2mars.model.cosmonaut.health.AbstractHealth;
import oneway2mars.util.constants.InitialGameConstants;

public class PhysicalHealth extends AbstractHealth {

	public PhysicalHealth() {
		setHealthState(InitialGameConstants.DEFAULT_CONDITION);
			//not used yet
		setRiskOfDeathFactor(0f);
	}
}
