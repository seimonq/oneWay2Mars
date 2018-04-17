package oneway2mars.util.methods;

import java.util.Collection;

public class MarsUtils {

	public static <T> T findElementByClass(Collection<? extends T> elementCollection, Class<?
			extends T> clazz) {
		return elementCollection.stream().filter(elem -> elem.getClass().equals(clazz))
				.findFirst().get();
	}

}
