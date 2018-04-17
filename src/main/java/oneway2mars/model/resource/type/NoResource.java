package oneway2mars.model.resource.type;

import oneway2mars.model.resource.AbstractResource;
import oneway2mars.model.resource.Resource;

/**
 * NoResource is used as a dummy in case no resouce should be defined
 */
public class NoResource extends AbstractResource implements Resource {

	@Override
	public void add(Float amount) {
		//no implementation intended
	}

}
