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
     * @return total production last round
     */
    Float getProducedLast();

    void setProducedLast(Float producedLast);

    /**
     *
     * @return total consumption last round
     */
    Float getConsumedLast();

    void setConsumedLast(Float consumedLast);


    /**
     *
     * @return total production this round
     */
    Float getProducedNow();

    void setProducedNow(Float producedNow);

    /**
     *
     * @return total consumption this round
     */
    Float getConsumedNow();

    void setConsumedNow(Float consumedNow);

    /**
     * set Now to Last values and empties Now values
     */
    void shiftToNextRound();

    void calcConsumedNow(List<Engine> workingEngines);

    void calcProducedNow(List<Engine> workingEngines);

    /**
     * used to determine total amount of resource after round
     */
    void calcAmountAfterRound();
}
