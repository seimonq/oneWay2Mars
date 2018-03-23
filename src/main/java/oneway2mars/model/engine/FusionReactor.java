package oneway2mars.model.engine;

import oneway2mars.model.resource.AbstractResource;

public class FusionReactor extends AbstractResource{

    private AbstractResource consumedResouce;
    private AbstractResource producedResouce;

    public AbstractResource getConsumedResouce() {
        return consumedResouce;
    }

    public void setConsumedResouce(AbstractResource consumedResouce) {
        this.consumedResouce = consumedResouce;
    }

    public AbstractResource getProducedResouce() {
        return producedResouce;
    }

    public void setProducedResouce(AbstractResource producedResouce) {
        this.producedResouce = producedResouce;
    }
}
