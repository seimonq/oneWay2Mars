package oneway2mars.model.resource;

import oneway2mars.model.engine.Engine;

import java.util.List;

public interface Resource {

    /**
     *
     * @return total amount when requested
     */
    Float getAmount();

    void setAmount(Float amount);

    /**
     *
     * @return total production last heartbeat
     */
    Float getProducedLast();

    void setProducedLast(Float producedLast);

    /**
     *
     * @return total consumption last heartbeat
     */
    Float getConsumedLast();

    void setConsumedLast(Float consumedLast);


    /**
     *
     * @return total production this heartbeat
     */
    Float getProducedNow();

    void setProducedNow(Float producedNow);

    /**
     *
     * @return total consumption this heartbeat
     */
    Float getConsumedNow();

    void setConsumedNow(Float consumedNow);

    /**
     * set Now to Last values and empties Now values
     */
    void shiftToNextHeartbeat();

    void calcConsumedNow(List<Engine> workingEngines);

    void calcProducedNow(List<Engine> workingEngines);

    /**
     * used to determine total amount of resource after heartbeat
     */
    void calcAmountAfterHeartbeat();

    /**
     * checks if given amount is available and returns true
     * otherwise false
     */
    boolean inStock(Float requestAmount);

}
