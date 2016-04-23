package io.archcentric.archaius.example;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.Collections;

import org.junit.Test;

import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringListProperty;
import com.netflix.config.DynamicStringMapProperty;
import com.netflix.config.DynamicStringProperty;

public class ApplicationConfigTest {

	@Test
	public void testBasicStringProps() {
		DynamicStringProperty stringProperty = DynamicPropertyFactory.getInstance().getStringProperty("hello.message",
				"default message");

		assertThat(stringProperty.get(), equalTo("Hello Archaius!"));
	}

	@Test
	public void shouldRetrieveDefaultValueWhenKeyIsNotPresent() {
		DynamicStringProperty stringProperty = DynamicPropertyFactory.getInstance().getStringProperty("some.key",
				"default message");

		assertThat(stringProperty.get(), is("default message"));
	}

	@Test
	public void testBasicListProps() {
		DynamicStringListProperty listProperty = new DynamicStringListProperty("listprop", Collections.emptyList());
		assertThat(listProperty.get(), contains("value1", "value2", "value3"));
	}

	@Test
	public void testBasicMapProps() {
		DynamicStringMapProperty mapProperty = new DynamicStringMapProperty("mapprop", Collections.emptyMap());
		assertThat(mapProperty.getMap(), allOf(hasEntry("key1", "value1"), hasEntry("key2", "value2")));
	}

	@Test
	public void testLongProperty() {
		DynamicLongProperty longProp = DynamicPropertyFactory.getInstance().getLongProperty("longprop", 1000);
		assertThat(longProp.get(), equalTo(100L));
	}
}
