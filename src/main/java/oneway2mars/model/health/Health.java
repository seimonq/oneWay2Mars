package oneway2mars.model.health;

public interface Health {

	/**
	 * current State of Health between 1..100
	 * @return
	 */
	Float getHealthState();

	void setHealthState();

	/**
	 * factor between 0..1 how likely death is
	 *
	 * @return
	 */
	Float getRiskOfDeathFactor();

	void setRiskOfDeathFactor();
}
