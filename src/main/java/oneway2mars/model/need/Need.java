package oneway2mars.model.need;

import javafx.util.Pair;
import oneway2mars.model.health.Health;
import oneway2mars.model.resource.Resource;

import java.util.Map;

public interface Need {

	/**
	 * Map with resources and amount taken when need needs to be satisfied
	 *
	 * @return
	 */
	Pair<Class<? extends Resource>, Float> getNeededResource();

	void setNeededResource(Pair<Class<? extends Resource>, Float> neededResourceMap);

	/**
	 * scale between 1..10 how urgent a need has to be satisfied
	 *
	 * @return
	 */
	Float getUrgency();

	void setUrgency(Float urgency);

	/**
	 * determines how fast urgency raises
	 *
	 * @return
	 */
	Float getUrgencyRate();

	void setUrgencyRate(Float urgencyRate);

	/**
	 * in case of satisfaction good and bad effect are stored for each {@link Health} type
	 *
	 * @return
	 */
	Map<Class<? extends Health>, Pair<Float, Float>> getSatisfactionMap();

	void setSatisfactionMap(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap);

	/**
	 * add delta to urgency each heartbeat
	 */
	void updateUrgency(Float delta);
}
