package oneway2mars.model.cosmonaut.health;

import javafx.util.Pair;

import java.util.Map;

public interface Health {

	/**
	 * current State of Health between 1..100
	 *
	 * @return
	 */
	Float getHealthState();

	void setHealthState(Float healthState);

	/**
	 * can be used to add or substract amount between MAX_AMOUNT and 0
	 */
	void add(Float addHealth);
}
