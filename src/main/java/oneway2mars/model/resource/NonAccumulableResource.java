package oneway2mars.model.resource;

/**
 * this resource can not be stored and accumlated
 * the produced amount in a heartbeat can be used within the heartbeat
 */
public interface NonAccumulableResource extends Resource{

    Float getUnusedAmount();

    void setUnusedAmount(Float unusedAmount);
}
