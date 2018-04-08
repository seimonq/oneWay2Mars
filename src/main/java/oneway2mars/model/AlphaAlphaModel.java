package oneway2mars.model;

import oneway2mars.model.cosmonaut.Cosmonaut;
import oneway2mars.model.engine.Engine;
import oneway2mars.model.event.Event;
import oneway2mars.model.resource.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlphaAlphaModel {


    private Set<Resource> resources;
    private Set<Engine> engines;
    private Set<Cosmonaut> cosmonauts;
    private Set<Event> events;


    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<Engine> getEngines() {
        return engines;
    }

    public void setEngines(Set<Engine> engines) {
        this.engines = engines;
    }

    public Set<Cosmonaut> getCosmonauts() {
        return cosmonauts;
    }

    public void setCosmonauts(Set<Cosmonaut> cosmonauts) {
        this.cosmonauts = cosmonauts;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }
}
