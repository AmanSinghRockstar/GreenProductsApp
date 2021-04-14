package com.local.greenproducts.model.ui.v1;

import java.util.HashMap;
import java.util.Map;

public class Style {
	private static final String PROPERTY_FORMAT = "%s: %s;";
	
	Map<String, String> propertiesMap = new HashMap<>();
	
	public void addProperty(String htmlTagName, String property, String value) {
		String propertyValue = String.format(PROPERTY_FORMAT, property, value);
		if (propertiesMap.containsKey(htmlTagName)) {
			propertyValue = propertiesMap.get(htmlTagName).concat(propertyValue);
		}
		propertiesMap.put(htmlTagName, propertyValue);
	}

	public String toString() {
		StringBuilder styleBuilder = new StringBuilder();
		propertiesMap.forEach((property, value) -> {
			styleBuilder.append(property).append("\t{").append(value).append("}\n");
		});
		return styleBuilder.toString();
	}
}
