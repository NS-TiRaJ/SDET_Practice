package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:configuration.properties"})
public interface BaseConfiguration extends Config {
    String url();
    String driverPath();
    String driverProperty();
}
