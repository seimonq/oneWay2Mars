package oneway2mars.model.resource;

public interface Resource {

    Float getAmount();

    void setAmount(Float amount);

    boolean isAccumulable();

    void setAccumulable(boolean accumulable);

}
