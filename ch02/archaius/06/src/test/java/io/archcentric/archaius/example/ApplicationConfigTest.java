package io.archcentric.archaius.example;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
public class ApplicationConfigTest {
	
	// passing the system property as a parameter to the VM when you start your application
	// java ... -Darchaius.configurationSource.additionalUrls=your_config.properties
	// or set it in the code using the following code.
	static {
	    System.setProperty("archaius.configurationSource.additionalUrls", 
	    		"https://raw.githubusercontent.com/archcentric/msabook_source/master/ch02/archaius/config/config.properties");
	}
    
    @Test
    public void testUrlOverridingProperty() {
    	DynamicLongProperty waitTimeProp = DynamicPropertyFactory.getInstance().getLongProperty("lock.waitTime", 200);
        assertThat(waitTimeProp.get(), equalTo(500L));
    }
}
