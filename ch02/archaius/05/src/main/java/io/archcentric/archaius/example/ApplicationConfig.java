package io.archcentric.archaius.example;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class ApplicationConfig {
	static {
		System.setProperty("archaius.dynamicPropertyFactory.registerConfigWithJMX", "true");
	}

	public static void main(String[] args) {
		DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty("hello.message",
				"default message");
		property.addCallback(new Runnable() {
			public void run() {
				System.out.println("property value updated!");
			}
		});

		while (true) {
			try {
				System.out.println(property.get());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		}
	}
}
