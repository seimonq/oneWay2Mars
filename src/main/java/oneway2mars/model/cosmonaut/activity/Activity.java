package oneway2mars.model.cosmonaut.activity;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;

import java.util.Map;
import java.util.Set;

public interface Activity {

	/**
	 * @return is activity in progress currently
	 */
	boolean isActive();

	void setActive(boolean active);

	/**
	 * @return activity reduces need urgency by given amount
	 * when a cosmonaut is doing this activity
	 */
	Pair<Class<? extends Need>,Float> getSatisfiedNeed();

	void setSatisfiedNeed(Pair<Class<? extends Need>,Float> need);

	/**
	 * @return amount of ticks this activity lasts
	 */
	Integer getDuration();

	void setDuration(Integer duration);

	/**
	 * @return tick when activity was started
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
	Float getSaturation();

	void setSaturation(Float saturation);

	/**
	 * multiply or devide saturation by
	 *
	 * @param factor
	 */
	void multiplySaturationBy(Float factor);

	/**
	 * @return map with {@link Health} type and amount of positive gain each tick when activity
	 * is active
	 */
	Map<Class<? extends Health>, Float> getHealthEffectMap();

	void setHealthEffectMap(Map<Class<? extends Health>, Float> healthEffectMap);

	/**
	 * @param currentTick current tick number
	 * @return true if activity should be continued
	 */
	boolean continueActivity(Long currentTick);

	/**
	 * set all necessary data when activity starts
	 *
	 * @param currentTick current tick number
	 */
	void startActivity(Long currentTick);

	/**
	 * updates amount of {@link Resource} in game
	 *
	 * @param resources of game model {@link Resource}
	 */
	void updateResource(Set<Resource> resources);


}
