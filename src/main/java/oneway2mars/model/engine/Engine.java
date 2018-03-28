package oneway2mars.model.engine;

import oneway2mars.model.resource.Resource;

public interface Engine {


    Class<? extends Resource> getConsumerType();

    void setConsumerType(Class<? extends Resource> clazz);

    Float getConsumationRate();

    Class<? extends Resource> getProducerType();

    void setProducerType(Class<? extends Resource> clazz);

    Float getProductionRate();

    boolean isActivated();

    void setActive(boolean active);

    String getName();

    void setCondition(Float condition);

    Float getCondition();

    }
