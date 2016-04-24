package io.archcentric.archaius.example;

import java.io.IOException;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class ApplicationConfig {

	public ApplicationConfig() {
		cascadeDefaultConfiguration();
	}

	private void cascadeDefaultConfiguration() {
		try {
			ConfigurationManager.loadCascadedPropertiesFromResources("config");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getStringProperty(String key, String defaultValue) {
		final DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty(key,
				defaultValue);
		return property.get();
	}
}