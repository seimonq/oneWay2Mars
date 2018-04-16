package oneway2mars.model.activity;

import oneway2mars.model.cosmonaut.health.Health;
import oneway2mars.model.cosmonaut.need.Need;
import oneway2mars.model.resource.Resource;
import oneway2mars.util.constants.classes.Effect;

import java.util.Map;
import java.util.Set;

public class AbstractActivity implements Activity {

	//todo implement

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public void setActive(boolean active) {

	}

	@Override
	public Class<? extends Need> getSatisfiedNeed() {
		return null;
	}

	@Override
	public void setSatisfiedNeed(Class<? extends Need> need) {

	}

	@Override
	public Integer getDuration() {
		return null;
	}

	@Override
	public void setDuration(Integer duration) {

	}

	@Override
	public Long getStarted() {
		return null;
	}

	@Override
	public void setStarted(Long lastStarted) {

	}

	@Override
	public Map<Class<? extends Resource>, Float> getConsumerMap() {
		return null;
	}

	@Override
	public void setConsumerMap(Map<Class<? extends Resource>, Float> consumerMap) {

	}

	@Override
	public Map<Class<? extends Resource>, Float> getProducerMap() {
		return null;
	}

	@Override
	public void setProducerMap(Map<Class<? extends Resource>, Float> producerMap) {

	}

	@Override
	public Float getSaturationFactor() {
		return null;
	}

	@Override
	public void setSaturationFactor(Float saturationFactor) {

	}

	@Override
	public Map<Class<? extends Health>, Effect> getHealthEffectMap() {
		return null;
	}

	@Override
	public boolean continueActivity() {
		return false;
	}

	@Override
	public void startActivity() {

	}

	@Override
	public void updateResource(Set<Resource> resources) {

	}
}
