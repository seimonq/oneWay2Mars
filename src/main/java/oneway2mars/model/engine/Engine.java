package oneway2mars.model.engine;

import oneway2mars.model.resource.Resource;

import java.util.List;
import java.util.Map;

public interface Engine {

	/**
	 * @return base constants for consumed resources
	 */
	Map<Class<? extends Resource>, Float> getConsumerMap();

	void setConsumerMap(Map<Class<? extends Resource>, Float> consumerMap);

	/**
	 * @return base constants for produced resources
	 */
	Map<Class<? extends Resource>, Float> getProducerMap();

	void setProducerMap(Map<Class<? extends Resource>, Float> producerMap);

	/**
	 * @return switched off or on status
	 */
	boolean isActivated();

	void setActive(boolean active);

	/**
	 * @return frontend name of engine
	 */
	String getName();

	void setName(String name);

	/**
	 * @return condition factor between 0..1 of engine
	 */
	Float getCondition();

	void setCondition(Float condition);


	/**
	 * @return efficiency factor between 0..1 which will be multiplied with production rate
	 */
	Float getEfficiency();

	void setEfficiency(Float efficiency);


	/**
	 * @return factor between 0..1 how much of needed consumed resources are available
	 */
	Float getResourceSaturation();

	void setResourceSaturation(Float resourceSaturation);

	/**
	 * consumes resource and updates amount
	 *
	 * @param resource consumed resource
	 * return {@Float} amount consumed
	 */
	Float consumeResource(Class<? extends Resource> resource);

	/**
	 * produces resource and updates amount
	 *
	 * @param resource produced resource
	 * return {@Float} amount produced
	 */
	Float produceResource(Class<? extends Resource> resource);

	/**
	 * used to multiply saturations over whole resource map
	 *
	 * @param resourceSaturation of specific resource
	 */
	void multiplyResourceSaturation(Float resourceSaturation);

	/**
	 * reset tick specific values
	 */
	void shiftToNextTick();

	/**
	 * sets efficiency for producing resources this tick
	 */
	void calcEfficiency();
}
