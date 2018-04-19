package oneway2mars.model.cosmonaut.type;

import oneway2mars.model.cosmonaut.AbstractCosmonaut;
import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.cosmonaut.activity.type.Eat;
import oneway2mars.model.cosmonaut.activity.type.Sleep;
import oneway2mars.model.cosmonaut.health.type.PhysicalHealth;
import oneway2mars.model.cosmonaut.need.type.Awakeness;
import oneway2mars.model.cosmonaut.need.type.Hunger;
import oneway2mars.util.constants.InitialGameConstants;

import java.util.Arrays;
import java.util.HashSet;

public class Siegmund extends AbstractCosmonaut implements Cosmonaut {
	public Siegmund() {
		setAlive(true);

		setHealthSet(new HashSet<>(Arrays.asList(new PhysicalHealth())));
		setNeeds(Arrays.asList(new Hunger(), new Awakeness()));
		setAvailableActivities(new HashSet<>(Arrays.asList(new Eat(), new Sleep())));

	}
}
