package oneway2mars.model.resource;

public abstract class AbstractAccumulableResource extends AbstractResource implements
        AccumulableResource {

    private Float maxStorableAmount;

    @Override
    public Float getMaxStorableAmount() {
        return maxStorableAmount;
    }

    @Override
    public void setMaxstorableAmount(Float maxstorableAmount) {

        this.maxStorableAmount = maxstorableAmount;
    }

    @Override
    public void add(Float addAmount) {
        setAmount(getAmount() + addAmount);
        if(getAmount() < 0) {
            setAmount(0f);
        }
        if(getAmount() > maxStorableAmount) {
            setAmount(maxStorableAmount);
        }
    }
}
