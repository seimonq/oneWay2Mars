package oneway2mars.model.engine;

import oneway2mars.model.resource.Resource;

public abstract class AbstractEngine implements Engine {

    protected String name = "engine";

    protected boolean activated;

    protected Class<? extends Resource> consumerType;
    protected Float consumationRate;
    protected Class<? extends Resource> producerType;
    protected Float productionRate;

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

    public void setConsumationRate(Float consumationRate) {
        this.consumationRate = consumationRate;
    }

    @Override
    public Float getProductionRate() {
        return productionRate;
    }

    public void setProductionRate(Float productionRate) {
        this.productionRate = productionRate;
    }

    @Override
    public String getName() {
        return name;
    }


}
