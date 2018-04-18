package oneway2mars.model.cosmonaut.activity.type;

import oneway2mars.model.cosmonaut.activity.AbstractActivity;
import oneway2mars.util.constants.InitialGameConstants;

public class Sleep extends AbstractActivity{

	public Sleep() {
		setDuration(InitialGameConstants.ACTIVITY_SLEEP_DURATION);
		setConsumerMap(InitialGameConstants.ACTIVITY_SLEEP_CONSUMER_MAP);
		setProducerMap(InitialGameConstants.ACTIVITY_SLEEP_PRODUCER_MAP);
		setHealthEffectMap(InitialGameConstants.ACTIVITY_SLEEP_HEALTH_EFFECT_MAP);

		setActive(false);
	}
}
