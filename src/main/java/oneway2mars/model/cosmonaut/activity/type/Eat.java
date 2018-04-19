package oneway2mars.model.cosmonaut.activity.type;

import oneway2mars.model.cosmonaut.activity.AbstractActivity;
import oneway2mars.model.cosmonaut.activity.Activity;
import oneway2mars.util.constants.InitialGameConstants;

public class Eat extends AbstractActivity implements Activity {

	public Eat() {
		setDuration(InitialGameConstants.ACTIVITY_EAT_DURATION);
		setConsumerMap(InitialGameConstants.ACTIVITY_EAT_CONSUMER_MAP);
		setProducerMap(InitialGameConstants.ACTIVITY_EAT_PRODUCER_MAP);
		setHealthEffectMap(InitialGameConstants.ACTIVITY_EAT_HEALTH_EFFECT_MAP);

		setActive(false);
	}
}
