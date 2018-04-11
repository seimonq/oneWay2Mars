package oneway2mars.model.cosmonaut;

import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;

import java.util.Set;

public interface Cosmonaut {

	/**
	 * Set of {@link Health} types
	 *
	 * @return
	 */
	Set<Health> getHealthSet();

	void setHealthSet(Set<Health> healthSet);

	/**
	 * these needs need to be satisfied in order to maintain health
	 *
	 * @return
	 */
	Set<Need> getNeedSet();

	void setNeedSet(Set<Need> needSet);

	/**
	 * condition for loosing the game, when a Cosmonaut is dead
	 *
	 * @return
	 */
	boolean isAlive();

	void setAlive(boolean alive);

	/**
	 * raise urgency of needs each heartbeat
	 */
	void updateNeeds();


}
