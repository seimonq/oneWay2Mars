package oneway2mars.model.cosmonaut.health.type;

import oneway2mars.model.cosmonaut.health.AbstractHealth;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.util.constants.InitialGameConstants;

public class PhysicalHealth extends AbstractHealth implements Health {

	public PhysicalHealth() {
		setHealthState(1f);
	}
}
