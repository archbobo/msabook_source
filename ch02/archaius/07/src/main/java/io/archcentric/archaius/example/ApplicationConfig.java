package io.archcentric.archaius.example;

import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;

public class ApplicationConfig {
    static {
        System.setProperty("archaius.dynamicPropertyFactory.registerConfigWithJMX", "true");
    }

    public String getStringProperty(String key, String defaultValue) {
        final DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty(key,
            defaultValue);
        return property.get();
    }


    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();

        while (true) {
            try {
                System.out.println(applicationConfig.getStringProperty("hello.message", "default message"));
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
