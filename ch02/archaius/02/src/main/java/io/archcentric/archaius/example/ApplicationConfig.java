package io.archcentric.archaius.example;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class ApplicationConfig {
	
	// passing the system property as a parameter to the vm when you start your application
	// java ... -Darchaius.configurationSource.defaultFileName=customConfig.properties
	// or set it in the code by uncommenting the following code.
//	static {
//	    System.setProperty("archaius.configurationSource.defaultFileName", "customConfig.properties");
//	}

    public String getStringProperty(String key, String defaultValue) {
        final DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty(key,
            defaultValue);
        return property.get();
    }
}
