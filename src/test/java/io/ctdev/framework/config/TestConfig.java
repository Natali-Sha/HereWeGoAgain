package io.ctdev.framework.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:testing.properties" })
public interface TestConfig extends Config, Reloadable {

    TestConfig cfg = ConfigFactory.create(TestConfig.class);

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("http://3.18.213.48/")
    String baseUrl();

    @DefaultValue("false")
    boolean remote();

    @DefaultValue("http://localhost:44444/wd/hub/")
    String remoteUrl();
}