package oneway2mars.controller;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.event.Event;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class UcEvent {

	/**
	 * gives the option that an event occures and returns it
	 *
	 * @param model whole model of game
	 * @return occured event awaiting decision
	 */
	public Optional<Event> optionForEvent(AlphaAlphaModel model) {

		Set<Event> possibleEvents = model.getEvents().stream().filter(ev -> ev.conditionMet
				(model) && !ev.isActive()).collect
				(Collectors.toSet());

		for (Event event : possibleEvents) {
			double luckyNumber = Math.random();
			if (luckyNumber < event.getChance()) {
				event.setActive(true);
				event.setLastOccurence(model.getCurrentTick());
				return Optional.of(event);
			}
		}
		return Optional.empty();
	}

	/**
	 * applies effect for active events
	 */
	public void applyEventEffects(AlphaAlphaModel model) {

		Set<Event> activeEvents = model.getEvents().stream().filter(ev -> ev.isActive()).collect(Collectors.toSet());
		if (!CollectionUtils.isEmpty(activeEvents)) {
			activeEvents.forEach(ev -> {
				ev.applyEffect(model);
				if (ev.checkDeactivation(model.getCurrentTick())) {
					ev.setDecision(null);
					ev.setActive(false);
				}
			});
		}
	}
}

