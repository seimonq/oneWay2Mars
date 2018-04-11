package oneway2mars.model.event.type;

import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.event.AbstractEvent;
import oneway2mars.model.event.Event;
import oneway2mars.model.resource.Resource;
import oneway2mars.model.resource.type.Food;

public class FindFood extends AbstractEvent implements Event {

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
		food.setAmount(food.getAmount() + 100.0f);
	}
}
