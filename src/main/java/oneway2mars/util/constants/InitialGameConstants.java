package oneway2mars.util.constants;

import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.cosmonaut.activity.Activity;
import oneway2mars.model.cosmonaut.activity.type.Eat;
import oneway2mars.model.cosmonaut.activity.type.Sleep;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.health.type.PhysicalHealth;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.cosmonaut.need.type.Awakeness;
import oneway2mars.model.cosmonaut.need.type.Hunger;
import oneway2mars.model.cosmonaut.type.Siegmund;
import oneway2mars.model.resource.Resource;
import oneway2mars.model.resource.type.Food;
import oneway2mars.util.classes.Effect;

import java.util.*;

import static javax.swing.UIManager.put;

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
	 * {@link Cosmonaut} {@link Siegmund}
	 */


	/**
	 * health configuration
	 */
	//nothing yet

	/**
	 * {@link Need}
	 */
	public static final Float NEED_SATISFACTION_THRESHOLD = .85f;
	public static final Float NEED_PENALTY_THRESHOLD = .95f;

	/**
	 * {@link Need} {@link Hunger}
	 */
	public final static Float NEED_HUNGER_URGENCY_RATE = .1f;
	public final static Map<Class<? extends Health>, Float> NEED_HUNGER_HEALTH_PENALTY_MAP = new
			HashMap<Class<? extends Health>, Float>() {
				{
					put(PhysicalHealth.class, .02f);
				}
			};
	/**
	 * {@link Need} {@link Awakeness}
	 */
	public static final Float NEED_AWAKENESS_URGENCY_RATE = 0.05f;
	public final static Map<Class<? extends Health>, Float> NEED_AWAKENESS_HEALTH_PENALTY_MAP = new
			HashMap<Class<? extends Health>, Float>() {{
				put(PhysicalHealth.class, 0.01f);
			}};
	/**
	 * {@link Activity} {@link Sleep}
	 */
	public static final Integer ACTIVITY_SLEEP_DURATION = 10;
	//blank intended
	public static final Map<Class<? extends Resource>, Float> ACTIVITY_SLEEP_CONSUMER_MAP = new HashMap<>();
	public static final Map<Class<? extends Resource>, Float> ACTIVITY_SLEEP_PRODUCER_MAP = new HashMap<>();
	public static final Map<Class<? extends Health>, Float> ACTIVITY_SLEEP_HEALTH_EFFECT_MAP = new
			HashMap<Class<? extends Health>, Float>() {{
				put(PhysicalHealth.class, .05f);
			}};

	/**
	 * {@link Activity} {@link Eat}
	 */
	public static final Integer ACTIVITY_EAT_DURATION = 1;
	//blank intended
	public static final Map<Class<? extends Resource>, Float> ACTIVITY_EAT_CONSUMER_MAP = new
			HashMap<Class<? extends Resource>, Float>() {{
				put(Food.class, 20f);
			}};
	public static final Map<Class<? extends Resource>, Float> ACTIVITY_EAT_PRODUCER_MAP = new HashMap<>();
	public static final Map<Class<? extends Health>, Float> ACTIVITY_EAT_HEALTH_EFFECT_MAP = new
			HashMap<Class<? extends Health>, Float>() {{
				put(PhysicalHealth.class, .15f);
			}};


}
