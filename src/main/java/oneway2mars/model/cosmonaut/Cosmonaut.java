package oneway2mars.model.cosmonaut;

import oneway2mars.model.need.Need;

import java.util.Map;
import java.util.Set;

public interface Cosmonaut {

	/**
	 * physical condition between 0..1
	 * @return
	 */
	Float getPhysicalHealth();
	void setPhysicalHealth(Float physicalHealth);

	/**
	 * mental condition between 0..1
	 * @return
	 */
	Float getMentalHealth();
	void setMentalHealth(Float mentalHealth);

	/**
	 * these needs need to be satisfied in order to maintain Health
	 * @return
	 */
	Set<Class<? extends Need>> getNeedSet();
	void setNeedSet(Set<Class<? extends Need>> needSet);

	/**
	 * condition for loosing the game, when a Cosmonaut is dead
	 * @return
	 */
	boolean isAlive();
	void setAlive(boolean alive);

}
