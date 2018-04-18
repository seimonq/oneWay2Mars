package oneway2mars.model.cosmonaut.need;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.resource.Resource;

import java.util.Map;

public interface Need {


	/**
	 * scale between 1..10 how urgent a need has to be satisfied
	 *
	 * @return
	 */
	Float getUrgency();

	void setUrgency(Float urgency);

	/**
	 * can be used to add or substract amount between 0 and 1
	 * @param amountAdded adds on existing urgency
	 */
	void addUrgency(Float amountAdded);

		/**
		 * determines how fast urgency raises
		 *
		 * @return
		 */
	Float getUrgencyRate();

	void setUrgencyRate(Float urgencyRate);

	/**
	 * in case of high urgency {@link Health} state is reduced by given value
	 *
	 * @return
	 */
	Map<Class<? extends Health>, Float> getHealthPenaltyMap();

	void setHealthPenaltyMap(Map<Class<? extends Health>, Float> healthPenaltyMap);

	/**
	 * add delta to urgency each tick
	 */
	void updateUrgency(Float delta);
}
