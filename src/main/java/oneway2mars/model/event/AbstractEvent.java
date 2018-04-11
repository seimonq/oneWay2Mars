package oneway2mars.model.event;

import oneway2mars.model.AlphaAlphaModel;

import java.util.Map;

public class AbstractEvent implements Event{

	private Float chance;
	private Long lastOccurence;
	private Integer effectTime;
	private Decision decision;
	private Map<EventText,String> eventText;
	private boolean active;

	@Override
	public Float getChance() {
		return chance;
	}

	@Override
	public void setChance(Float chance) {
		this.chance = chance;
	}

	@Override
	public Long getLastOccurence() {
		return lastOccurence;
	}

	@Override
	public void setLastOccurence(Long lastOccurence) {
		this.lastOccurence = lastOccurence;
	}

	@Override
	public Integer getEffectTime() {
		return effectTime;
	}

	@Override
	public void setEffectTime(Integer effectTime) {
		this.effectTime = effectTime;
	}

	@Override
	public Decision getDecision() {
		return decision;
	}

	@Override
	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	@Override
	public String getEventText(EventText eventText) {
		return this.eventText.get(eventText);
	}

	@Override
	public void setEventText(EventText type, String eventText) {
		this.eventText.put(type, eventText);
	}

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public boolean checkDeactivation(Long currentHeartbeat) {
		return (getLastOccurence() + getEffectTime() >= currentHeartbeat);
	}

	@Override
	public boolean conditionMet(AlphaAlphaModel model) {
		//overwrite this in subclass
		return false;
	}

	@Override
	public void applyEffect(AlphaAlphaModel model) {
		//overwrite this in subclass
	}
}
