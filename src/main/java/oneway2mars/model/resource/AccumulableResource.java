package oneway2mars.model.resource;

/**
 * this resource can be accumulated each tick up to a max. storable amount
 */
public interface AccumulableResource extends Resource {

    Float getMaxStorableAmount();

    void setMaxstorableAmount(Float maxstorableAmount);
}
