package oneway2mars.model.resource;

public class AbstractAccumulableResource extends AbstractResource implements AccumulableResource {

    private Float maxStorableAmount;

    @Override
    public Float getMaxStorableAmount() {
        return maxStorableAmount;
    }

    @Override
    public void setMaxstorableAmount(Float maxstorableAmount) {

        this.maxStorableAmount = maxstorableAmount;
    }
}
