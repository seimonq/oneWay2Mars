package oneway2mars.model.cosmonaut.activity;

import javafx.util.Pair;
import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractActivity implements Activity {

	private boolean active;
	private Float saturation;
	private Pair<Class<? extends Need>,Float> satisfiedNeed;
	private Integer duration;
	private Long startedAt;

	private Map<Class<? extends Resource>, Float> consumerMap = new HashMap<>();

	private Map<Class<? extends Resource>, Float> producerMap = new HashMap<>();
	private Map<Class<? extends Health>, Float> healthEffectMap = new HashMap<>();

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public Pair<Class<? extends Need>,Float> getSatisfiedNeed() {
		return satisfiedNeed;
	}

	@Override
	public void setSatisfiedNeed(Pair<Class<? extends Need>,Float> satisfiedNeed) {
		this.satisfiedNeed = satisfiedNeed;
	}

	@Override
	public Integer getDuration() {
		return duration;
	}

	@Override
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public Long getStarted() {
		return startedAt;
	}

	@Override
	public void setStarted(Long startedAt) {
		this.startedAt = startedAt;
	}

	@Override
	public Map<Class<? extends Resource>, Float> getConsumerMap() {
		return consumerMap;
	}

	@Override
	public void setConsumerMap(Map<Class<? extends Resource>, Float> consumerMap) {
		this.consumerMap = consumerMap;
	}

	@Override
	public Map<Class<? extends Resource>, Float> getProducerMap() {
		return producerMap;
	}

	@Override
	public void setProducerMap(Map<Class<? extends Resource>, Float> producerMap) {
		this.producerMap = producerMap;
	}

	@Override
	public Float getSaturation() {
		return saturation;
	}

	@Override
	public void setSaturation(Float saturation) {
		this.saturation = saturation;
	}

	@Override
	public void multiplySaturationBy(Float factor) {
		if (saturation == null) {
			saturation = 1f;
		}
		saturation *= factor;

		saturation = ((saturation < 0f) ? 0f : saturation);
		saturation = ((saturation > 1f) ? 1f : saturation);
	}

	@Override
	public Map<Class<? extends Health>, Float> getHealthEffectMap() {
		return healthEffectMap;
	}

	@Override
	public void setHealthEffectMap(Map<Class<? extends Health>, Float> healthEffectMap) {
		this.healthEffectMap = healthEffectMap;
	}

	@Override
	public boolean continueActivity(Long currentTick) {
		return startedAt + duration > currentTick;
	}

	@Override
	public void startActivity(Long currentTick) {
		setActive(true);
		setStarted(currentTick);
		setSaturation(1f);
	}

	@Override
	public void updateResource(Set<Resource> resources) {
		// todo remove
	}
}
