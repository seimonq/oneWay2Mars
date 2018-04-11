package oneway2mars.model.cosmonaut.health;

import javafx.util.Pair;

import java.util.Map;

public interface Health {

	/**
	 * current State of Health between 1..100
	 * @return
	 */
	Float getHealthState();

	void setHealthState(Float healthState);

	/**
	 * factor between 0..1 how likely death is
	 *
	 * @return
	 */
	Float getRiskOfDeathFactor();

	void setRiskOfDeathFactor(Float riskOfDeathFactor);

	/**
	 * satisfaction effects on health
	 */

	void satisfy(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap);

	/**
	 * dissatisfaction effects on health
	 */
	void dissatisfy(Map<Class<? extends Health>, Pair<Float, Float>> satisfactionMap);
}
