package oneway2mars.controller;

import oneway2mars.AlphaAlphaMarsApplication;
import oneway2mars.model.AlphaAlphaModel;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.Resource;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceController {

    private AlphaAlphaMarsApplication app;

    public ResourceController(AlphaAlphaMarsApplication app) {
        this.app = app;
    }

    public void updateResources(AlphaAlphaModel model) {
        model.getEngines().stream().filter(engine -> engine.isActivated()).forEach(engine -> processEngines(engine));
    }

    private void processEngines(Engine engine) {
        Resource consumedResource = app.getGameModel().getResources().stream().filter(res -> engine.getConsumerType().equals(res.getClass())).findFirst().get();
        consumedResource.setAmount(consumedResource.getAmount() + engine.getConsumationRate());

        Resource producedResource = app.getGameModel().getResources().stream().filter(res -> engine.getProducerType().equals(res.getClass())).findFirst().get();
        producedResource.setAmount(producedResource.getAmount() + engine.getProductionRate());
    }
}
