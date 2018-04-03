package oneway2mars.model.engine;

import oneway2mars.model.resource.Resource;

import java.util.Map;

public abstract class AbstractEngine implements Engine {

	private String name;
	private boolean activated;
	private Float condition;
	private Float resourceSaturation;
	private Float efficiency;

	private Map<Class<? extends Resource>, Float> consumerMap;
	private Map<Class<? extends Resource>, Float> producerMap;


	@Override
	public boolean isActivated() {
		return activated;
	}

	@Override
	public void setActive(boolean activated) {
		this.activated = activated;
	}


	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Float getCondition() {
		return condition;
	}

	@Override
	public void setCondition(Float condition) {
		this.condition = condition;
	}

	@Override
	public Map<Class<? extends Resource>, Float> getConsumerMap() {
		return consumerMap;
	}

	@Override
	public void setConsumerMap(Map<Class<? extends Resource>, Float> consumerMap) {
		this.consumerMap = consumerMap;
	}

	@Override
	public Map<Class<? extends Resource>, Float> getProducerMap() {
		return producerMap;
	}

	@Override
	public void setProducerMap(Map<Class<? extends Resource>, Float> producerMap) {
		this.producerMap = producerMap;
	}

	@Override
	public Float getEfficiency() {
		return efficiency;
	}

	@Override
	public void setEfficiency(Float efficiency) {
		this.efficiency = efficiency;
	}

	@Override
	public Float getResourceSaturation() {
		return this.resourceSaturation;
	}

	@Override
	public void setResourceSaturation(Float resourceSaturation) {
		this.resourceSaturation = resourceSaturation;
	}

	@Override
	public Float consumeResource(Class<? extends Resource> resource) {
		//not used yet
		return null;
	}

	@Override
	public Float produceResource(Class<? extends Resource> resource) {
		return producerMap.get(resource) * getEfficiency();
	}

	@Override
	public void shiftToNextRound() {
		resourceSaturation = 1.0f;
	}

	@Override
	public void calcEfficiency() {
		efficiency = condition * resourceSaturation;
	}

	@Override
	public void multiplyResourceSaturation(Float resourceSaturation) {
		this.resourceSaturation *= resourceSaturation;
	}

}
