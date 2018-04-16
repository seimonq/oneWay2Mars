package oneway2mars.model.activity;

import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.constants.classes.Effect;

import java.util.Map;
import java.util.Set;

public interface Activity {

	/**
	 * @return is activity in progress currently
	 */
	boolean isActive();

	void setActive(boolean active);

	/**
	 * @return activity reduces need urgency when an cosmonaut is doing this activity
	 */
	Class<? extends Need> getSatisfiedNeed();

	void setSatisfiedNeed(Class<? extends Need> need);

	/**
	 * @return amount of heartbeats this activity lasts
	 */
	Integer getDuration();

	void setDuration(Integer duration);

	/**
	 * @return heartbeat when activity was started
	 */
	Long getStarted();

	void setStarted(Long lastStarted);

	/**
	 * resources consumed each round for this activity
	 *
	 * @return map of {@link Resource} and amount
	 */
	Map<Class<? extends Resource>, Float> getConsumerMap();

	void setConsumerMap(Map<Class<? extends Resource>, Float> consumerMap);

	/**
	 * resources produced by this activity
	 *
	 * @return map of {@link Resource} and amount
	 */
	Map<Class<? extends Resource>, Float> getProducerMap();

	void setProducerMap(Map<Class<? extends Resource>, Float> producerMap);

	/**
	 * if not all consumed resources are available this saturation factor is < 1
	 * this factor will be multiplied with the urgency decrease of the reducing need
	 *
	 * @return
	 */
	Float getSaturationFactor();

	void setSaturationFactor(Float saturationFactor);

	/**
	 * @return map of {@link Effect} for each {@link Health} type
	 */
	Map<Class<? extends Health>, Effect> getHealthEffectMap();

	/**
	 * @return true if activity should be continued
	 */
	boolean continueActivity();

	/**
	 * set all necessary data when activity starts
	 */
	void startActivity();

	/**
	 * updates amount of {@link Resource} in game
	 * @param resources of game model {@link Resource}
	 */
	void updateResource(Set<Resource> resources);


}
