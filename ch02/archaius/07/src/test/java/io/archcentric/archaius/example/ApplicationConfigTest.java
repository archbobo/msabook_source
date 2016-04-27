package io.archcentric.archaius.example;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.netflix.config.ConfigurationManager;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;

public class ApplicationConfigTest {

	// passing the system property as a parameter to the VM when you start your
	// application
	// java ... -Darchaius.deployment.environment=prod
	// or set it in the code.
	@Before
	public void setUp() throws Exception {
		System.setProperty("archaius.deployment.environment", "prod");
		System.setProperty("archaius.deployment.applicationId", "app");

		String appId = ConfigurationManager.getDeploymentContext().getApplicationId();
		ConfigurationManager.loadCascadedPropertiesFromResources(appId);
	}

	@Test
	public void testProdEnvironmentOverridingProperty() {
		DynamicLongProperty waitTimeProp = DynamicPropertyFactory.getInstance().getLongProperty("lock.waitTime", 100);
		assertThat(waitTimeProp.get(), equalTo(500L));
	}

}
