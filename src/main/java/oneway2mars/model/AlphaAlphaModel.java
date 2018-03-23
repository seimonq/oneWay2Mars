package oneway2mars.model;

import oneway2mars.model.engine.Engine;
import oneway2mars.model.resource.Resource;

import java.util.ArrayList;
import java.util.List;

public class AlphaAlphaModel {


    private List<Resource> resources = new ArrayList<>();
    private List<Engine> engines = new ArrayList<>();

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public void setEngines(List<Engine> engines) {
        this.engines = engines;
    }




}
