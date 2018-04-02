package oneway2mars.controller;

import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.model.resource.NonAccumulableResource;
import oneway2mars.model.resource.Resource;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResourceController {

	private AlphaAlphaModel model;

	public ResourceController(AlphaAlphaModel model) {
		this.model = model;
	}

	public void updateResources(AlphaAlphaModel model) {
		model.getEngines().forEach(eng -> eng.shiftToNextRound());

		model.getResources().forEach( res -> {
			res.shiftToNextRound();
			res.calcConsumedNow(model.getEngines());
		});

		model.getEngines().forEach(eng -> eng.calcEfficiency());
		model.getResources().forEach( res -> res.calcProducedNow(model.getEngines()));


		//old
//		model.getEngines().stream().filter(engine -> engine.isActivated()).forEach(engine ->
//				processProduction(engine.getProducerType(), engine.getProductionRate()));
//
//		model.getResources().stream().filter(res -> NonAccumulableResource.class.isAssignableFrom
//				(res.getClass())).forEach(res -> ((NonAccumulableResource) res)
//				.setUnusedAmount(res.getAmount()));
//
//		model.getEngines().stream().filter(engine -> engine.isActivated()).forEach(engine ->
//				processConsumation(engine.getConsumerType(), engine.getConsumationRate()));
	}

//	private void processProduction(Class productionType, Float productionRate) {
//
//		Optional<? extends Resource> producedResourceOptional = model.getResources()
//				.stream().filter(res -> productionType.equals(res.getClass())).findFirst();
//
//		if (producedResourceOptional.isPresent()) {
//
//			Resource productionResource = producedResourceOptional.get();
//
//			if (AccumulableResource.class.isAssignableFrom(productionResource.getClass())) {
//
//				productionResource.setAmount(productionResource.getAmount() + productionRate);
//
//			} else if (NonAccumulableResource.class.isAssignableFrom(productionResource.getClass())) {
//
//				productionResource.setAmount(productionRate);
//
//			}
//		}
//	}
//
//	private void processConsumation(Class consumationType, Float consumationRate) {
//
//		// do this similar to processProduction
//
//		Optional<? extends Resource> consumedResourceOption = model.getResources().stream().filter(res ->
//				consumationType.equals(res.getClass())).findFirst();
//
//		if (consumedResourceOption.isPresent()) {
//
//			Resource consumedResource = consumedResourceOption.get();
//
//			if (AccumulableResource.class.isAssignableFrom(consumedResource.getClass())) {
//
//				consumedResource.setAmount(consumedResource.getAmount() - consumationRate);
//
//			} else if (NonAccumulableResource.class.isAssignableFrom(consumedResource.getClass())) {
//
//				((NonAccumulableResource) consumedResource).setUnusedAmount((
//						(NonAccumulableResource) consumedResource).getUnusedAmount() -
//						consumationRate);
//			}
//
//		}
//	}
}
