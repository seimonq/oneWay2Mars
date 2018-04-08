package oneway2mars.model.resource;

import oneway2mars.model.engine.Engine;

import java.util.ArrayList;
import java.util.List;

public class AbstractResource implements Resource {

	private Float amount;
	private Float producedLast;
	private Float consumedLast;
	private Float producedNow;
	private Float consumedNow;

	@Override
	public Float getAmount() {
		return amount;
	}

	@Override
	public void setAmount(Float amount) {
		this.amount = amount;
	}

	@Override
	public Float getProducedLast() {
		return producedLast;
	}

	@Override
	public void setProducedLast(Float producedLast) {
		this.producedLast = producedLast;
	}

	@Override
	public Float getConsumedLast() {
		return consumedLast;
	}

	@Override
	public void setConsumedLast(Float consumedLast) {
		this.consumedLast = consumedLast;
	}

	@Override
	public Float getProducedNow() {
		return producedNow;
	}

	@Override
	public void setProducedNow(Float producedNow) {
		this.producedNow = producedNow;
	}

	@Override
	public Float getConsumedNow() {
		return consumedNow;
	}

	@Override
	public void setConsumedNow(Float consumedNow) {
		this.consumedNow = consumedNow;
	}

	@Override
	public void shiftToNextHeartbeat() {
		consumedLast = consumedNow;
		producedLast = producedNow;

		consumedNow = 0f;
		producedNow = 0f;
	}

	@Override
	public void calcConsumedNow(List<Engine> workingEngines) {
		if (consumedNow == null) {
			consumedNow = 0f;
		}
		Float overDemandRatio;
		List<Engine> enginesUsingResource = new ArrayList<>();

		workingEngines.forEach(
				eng -> eng.getConsumerMap().forEach(
						(consumedResource, baseConsumptionRate) -> {
							if (consumedResource.equals(this.getClass())) {
								enginesUsingResource.add(eng);
								consumedNow += baseConsumptionRate;
							}
						}));
		if(amount < consumedNow) {
			overDemandRatio = amount / consumedNow;
			enginesUsingResource.forEach(eng -> eng.multiplyResourceSaturation(overDemandRatio));
			consumedNow = amount;
		}

	}

	@Override
	public void calcProducedNow(List<Engine> workingEngines) {
		if(producedNow == null) {
			producedNow = 0f;
		}
		workingEngines.forEach( eng -> eng.getProducerMap().forEach(
				(producedResource,baseProductionRate) -> {
					if(producedResource.equals(this.getClass())) {
						producedNow += eng.produceResource(producedResource);
					}
				}
		));

	}

	@Override
	public void calcAmountAfterHeartbeat() {
		if(this instanceof AccumulableResource) {
			amount -= consumedNow;
			amount += producedNow;
		}
		else if(this instanceof NonAccumulableResource) {
			amount = producedNow;
		}
	}

	@Override
	public boolean inStock(Float requestAmount) {
		if(requestAmount == null || requestAmount == 0.0f || requestAmount < amount) {
			return true;
		}
		return false;

	}
}
