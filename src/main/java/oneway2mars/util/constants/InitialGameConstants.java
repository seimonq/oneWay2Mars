package oneway2mars.util.constants;

import javafx.util.Pair;
import oneway2mars.model.resource.Resource;
import oneway2mars.model.resource.type.Food;

public final class InitialGameConstants {

	/**
	 * some commonly used values
	 */

	public final static Float DEFAULT_CONDITION = 1.0f;
	public final static Integer HEARTBEAT_PULSE = 2500;
	/**
	 * engine configuration
	 */
	public final static Float AIR_CONDITIONER_CONS_RATE = 2.0f;
	public final static Float AIR_CONDITIONER_PROD_RATE = .1f;

	public final static Float HYDROGEN_GENERATOR_CONS_RATE = 4.0f;
	public final static Float HYDROGEN_GENERATOR_PROD_RATE = .2f;

	public final static Float INSECT_FARM_CONS_RATE = 2.0f;
	public final static Float INSECT_FARM_PROD_RATE = .1f;

	public final static Float NUCLEAR_REACTOR_PROD_RATE = 5.0f;

	public final static Float OXIGEN_GENERATOR_CONS_RATE = 2.0f;
	public final static Float OXIGEN_GENERATOR_PROD_RATE = .2f;

	public final static Float ROVER_CONS_RATE = .2f;
	public final static Float ROVER_PROD_RATE = .4f;

	public final static Float WATER_TREATMENT_CONS_RATE = 2.0f;
	public final static Float WATER_TREATMENT_PROD_RATE = .2f;


	/**
	 * resource configuration
	 */

	public final static Float ENERGY_INIT_AMOUNT = 5.0f;

	public final static Float FOOD_INIT_AMOUNT = 50.0f;
	public final static Float FOOD_INIT_AMOUNT_MAX = 200.0f;

	public final static Float ORE_INIT_AMOUNT = 10.0f;
	public final static Float ORE_INIT_AMOUNT_MAX = 200.0f;

	public final static Float OXIGEN_INIT_AMOUNT = 20.0f;
	public final static Float OXIGEN_INIT_AMOUNT_MAX = 100.0f;

	public final static Float TEMPERATURE_INIT_AMOUNT = 20.0f;

	public final static Float WATER_INIT_AMOUNT = 100.0f;
	public final static Float WATER_INIT_AMOUNT_MAX = 400.0f;

	/**
	 * cosmonaut configuration
	 */
	//nothing yet

	/**
	 * health configuration
	 */


	/**
	 * need configuration
	 */
	public final static Float NEED_HUNGER_URGENCY_RATE = .1f;
	public final static Pair<Float, Float> NEED_HUNGER_SATISFACTION_HEALTH_PHYSICAL = new
			Pair<>(.05f, .01f);
	public final static Pair<Class<? extends Resource>, Float> NEED_HUNGER_RESOURCE_FOOD = new
			Pair(Food.class, 20f);

	public static final Float NEED_SATISFACTION_THRESHOLD = .95f;
}
