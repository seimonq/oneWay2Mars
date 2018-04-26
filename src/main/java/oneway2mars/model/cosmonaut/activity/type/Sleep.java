package oneway2mars.model.cosmonaut.activity.type;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.activity.AbstractActivity;
import oneway2mars.model.cosmonaut.activity.Activity;
import oneway2mars.model.cosmonaut.need.type.Awakeness;
import oneway2mars.util.constants.InitialGameConstants;

public class Sleep extends AbstractActivity implements Activity {

	public Sleep() {
		setDuration(InitialGameConstants.ACTIVITY_SLEEP_DURATION);
		setConsumerMap(InitialGameConstants.ACTIVITY_SLEEP_CONSUMER_MAP);
		setProducerMap(InitialGameConstants.ACTIVITY_SLEEP_PRODUCER_MAP);
		setHealthEffectMap(InitialGameConstants.ACTIVITY_SLEEP_HEALTH_EFFECT_MAP);
		setSatisfiedNeed(new Pair(Awakeness.class, InitialGameConstants.ACTIVITY_SLEEP_SATISFACTION));

		setActive(false);
	}
}
