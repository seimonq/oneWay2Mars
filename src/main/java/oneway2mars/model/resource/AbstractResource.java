package oneway2mars.model.resource;

public class AbstractResource implements Resource{

    private Float amount;

    @Override
    public Float getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
