package oneway2mars.model.cosmonaut;

import oneway2mars.model.cosmonaut.activity.Activity;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;

import java.util.List;
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
	 * @return ordered list by urgency of needs for cosmonaut
	 */
	List<Need> getNeeds();

	void setNeeds(List<Need> needSet);

	/**
	 * condition for loosing the game, when a Cosmonaut is dead
	 *
	 * @return
	 */
	boolean isAlive();

	void setAlive(boolean alive);

	/**
	 * raise urgency of needs each tick
	 */
	void shiftToNextTick();

	/**
	 * stores last activity of cosmonaut
	 *
	 * @return value of {@link Activity}
	 */
	Activity getLastActivity();

	void setLastActivity(Activity activity);

	/**
	 * stores current activity of cosmonaut
	 *
	 * @return value of {@link Activity}
	 */
	Activity getCurrentActivity();

	void setCurrentActivity(Activity activity);

	/**
	 * @return all possible {@link Activity} for {@link Cosmonaut}
	 */
	Set<Activity> getAvailableActivities();

	void setAvailableActivities(Set<Activity> availableActivities);

	/**
	 * update resources and health state
	 */
	void processActivity(Set<Resource> resources);

	/**
	 * sets a new Activity when the current is done
	 */
	void updateActivity();
}
