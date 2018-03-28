package oneway2mars.model.resource;

public class AbstractResource {

    private Float amount;
    protected boolean accumulable;

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public boolean isAccumulable() {
        return accumulable;
    }

    public void setAccumulable(boolean accumulable) {
        this.accumulable = accumulable;
    }
}
