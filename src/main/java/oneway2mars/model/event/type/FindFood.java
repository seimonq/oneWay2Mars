package oneway2mars.model.event.type;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.event.AbstractEvent;
import oneway2mars.model.event.Decision;
import oneway2mars.model.event.Event;
import oneway2mars.model.event.EventText;
import oneway2mars.model.resource.Resource;
import oneway2mars.model.resource.type.Food;

public class FindFood extends AbstractEvent implements Event {

	public FindFood() {
		setEventText(EventText.Question, "Die Vorräte werden knapp, und du erinnerst dich, dass " +
				"es eventuell noch in der Landungskapsel etwas geben könnte, willst du nach " +
				"schauen? *ja*/*nein*");
		setEventText(EventText.DecisionA, "Du findest 100 Rationen.");
		setEventText(EventText.DecisionB, "Du gehst nicht nachschauen, aber du zählst nochmal " +
				"die Rationen durch und merkst, dass es 10 Rationen mehr sind als gedacht.");
	}

	@Override
	public boolean conditionMet(AlphaAlphaModel model) {
		Resource food = model.getResources().stream().filter(res -> res.getClass().equals(Food
				.class)).findFirst().get();

		return food.getAmount() < 30.0f;

	}

	@Override
	public void applyEffect(AlphaAlphaModel model) {

		Resource food = model.getResources().stream().filter(res -> res.getClass().equals(Food
				.class)).findFirst().get();

		if (getDecision() == Decision.ACCEPTED) {
			food.setAmount(food.getAmount() + 50.0f);
		} else if (getDecision() == Decision.DENIED) {
			food.setAmount(food.getAmount() + 5.0f);
		}
	}
}
