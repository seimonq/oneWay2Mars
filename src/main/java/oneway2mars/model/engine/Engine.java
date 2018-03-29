package oneway2mars.model.engine;

import oneway2mars.model.resource.Resource;

public interface Engine {


    Class<? extends Resource> getConsumerType();

    void setConsumerType(Class<? extends Resource> clazz);

    Float getConsumationRate();

    void setConsumationRate(Float productionRate);

    Class<? extends Resource> getProducerType();

    void setProducerType(Class<? extends Resource> clazz);

    Float getProductionRate();

    void setProductionRate(Float productionRate);

    boolean isActivated();

    void setActive(boolean active);

    String getName();

    void setName(String name);

    void setCondition(Float condition);

    Float getCondition();

    }
