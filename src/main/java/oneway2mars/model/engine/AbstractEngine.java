package oneway2mars.model.engine;

import oneway2mars.model.resource.Resource;

public abstract class AbstractEngine implements Engine {

	private String name = "engine";

	private boolean activated;
	private Float condition;

	private Class<? extends Resource> consumerType;
	private Float consumationRate;

	private Class<? extends Resource> producerType;
	private Float productionRate;

	@Override
	public Class<? extends Resource> getConsumerType() {
		return consumerType;
	}

	@Override
	public void setConsumerType(Class<? extends Resource> consumerType) {
		this.consumerType = consumerType;
	}

	@Override
	public Class<? extends Resource> getProducerType() {
		return producerType;
	}

	@Override
	public void setProducerType(Class<? extends Resource> producerType) {
		this.producerType = producerType;
	}

	@Override
	public boolean isActivated() {
		return activated;
	}

	@Override
	public void setActive(boolean activated) {
		this.activated = activated;
	}

	@Override
	public Float getConsumationRate() {
		return consumationRate;
	}

	@Override
	public void setConsumationRate(Float consumationRate) {
		this.consumationRate = consumationRate;
	}

	@Override
	public Float getProductionRate() {
		return productionRate;
	}

	@Override
	public void setProductionRate(Float productionRate) {
		this.productionRate = productionRate;
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

}
