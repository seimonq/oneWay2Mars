package oneway2mars.model.resource;

/**
 * this resource can not be stored and accumlated
 * the produced amount in a round can be used within the round
 */
public interface NonAccumulableResource extends Resource{

    Float getUnusedAmount();

    void setUnusedAmount(Float unusedAmount);
}
