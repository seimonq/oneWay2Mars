package oneway2mars.model.event;

import oneway2mars.model.AlphaAlphaModel;

public interface Event {

	/**
	 * how likely the event is
	 * @return
	 */
	Float getChance();

	void setChance(Float chance);
	/**
	 * when did it occur last time
	 * @return
	 */
	Long getLastOccurence();

	void setLastOccurence(Long lastOccurence);
	/**
	 * how long does the effect last of event
	 * @return
	 */
	Integer getEffectTime();

	void setEffectTime(Integer effectTime);
	/**
	 * stores last decision taken by user
	 * @return
	 */
	Decision getDecision();

	void setDecision(Decision decision);
	/**
	 * retrives stored eventText tiles
	 * @param eventText
	 * @return Text to given EventText type
	 */
	String getEventText(EventText eventText);

	/**
	 * sets one pair in map
	 * @param type
	 * @param eventText
	 */
	void setEventText(EventText type, String eventText);
	/**
	 * when an Event is active it means that the effect will be applied
	 * @return boolean
	 */
	boolean isActive();

	void setActive(boolean active);
	/**
	 * only when this is true an effect can occure
	 * @param model
	 * @return boolean
	 */
	boolean conditionMet(AlphaAlphaModel model);

	/**
	 * when an event is active this effect will be applied
	 * @param model
	 */
	void applyEffect(AlphaAlphaModel model);

	/**
	 * checks of effectTime is over
	 * @param currentHeartbeat
	 * @return true means deactivate event and do not apply effect any more
	 */
	boolean checkDeactivation(Long currentHeartbeat);

}
