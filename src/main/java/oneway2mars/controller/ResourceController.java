package oneway2mars.controller;

import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.AccumulableResource;
import oneway2mars.model.resource.NonAccumulableResource;
import oneway2mars.model.resource.Resource;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResourceController {

	private AlphaAlphaModel model;

	public ResourceController(AlphaAlphaModel model) {
		this.model = model;
	}

	public void updateResources(AlphaAlphaModel model) {


		model.getEngines().stream().filter(engine -> engine.isActivated()).forEach(engine ->
				processProduction(engine.getProducerType(), engine.getProductionRate()));

		model.getResources().stream().filter(res -> res.getClass().isAssignableFrom
				(NonAccumulableResource.class)).forEach(res -> ((NonAccumulableResource) res)
				.setUnusedAmount(res.getAmount()));

		model.getEngines().stream().filter(engine -> engine.isActivated()).forEach(engine ->
				processConsumation(engine.getConsumerType(), engine.getConsumationRate()));
	}

	private void processProduction(Class productionType, Float productionRate) {
		Optional<Resource> producedAccumulableResourceOption = model.getResources()
				.stream().filter(res ->
						productionType.equals(res.getClass()) && AccumulableResource.class
								.isAssignableFrom(res.getClass())).findFirst();

		if (producedAccumulableResourceOption.isPresent()) {
			Resource producedNonAccumulableResource = producedAccumulableResourceOption.get();
			producedNonAccumulableResource.setAmount(producedNonAccumulableResource
					.getAmount() + productionRate);
		}

		Optional<Resource> producedNonAccumulableResourceOption = model.getResources()
				.stream().filter(res ->
						productionType.equals(res.getClass()) && NonAccumulableResource.class
								.isAssignableFrom(res.getClass())).findFirst();

		if (producedNonAccumulableResourceOption.isPresent()) {
			Resource producedNonAccumulableResource = producedNonAccumulableResourceOption.get();
			producedNonAccumulableResource.setAmount(productionRate);
		}

	}

	private void processConsumation(Class consumationType, Float consumationRate) {

		// do this similar to processProduction

		Optional<Resource> consumedResourceOption = model.getResources().stream().filter(res ->
				consumationType.equals(res.getClass())).findFirst();

		if (consumedResourceOption.isPresent()) {

			Resource consumedResource = consumedResourceOption.get();
			if (AccumulableResource.class.isAssignableFrom(consumedResource.getClass())) {

				consumedResource.setAmount(consumedResource.getAmount() + consumationRate);

			} else if (NonAccumulableResource.class.isAssignableFrom(consumedResource.getClass())) {

				((NonAccumulableResource) consumedResource).setUnusedAmount((
						(NonAccumulableResource) consumedResource).getUnusedAmount() + consumationRate);
			}

		}
	}
}
