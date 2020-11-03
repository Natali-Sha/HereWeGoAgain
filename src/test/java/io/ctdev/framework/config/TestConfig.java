package io.ctdev.framework.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/test/resources/base.testing.properties",
        "file:src/test/resources/remote.testing.properties",
        "file:src/test/resources/remoteUrl.testing.properties",
        "file:src/test/resources/browser.testing.properties"})
public interface TestConfig extends Config, Reloadable {

    TestConfig cfg = ConfigFactory.create(TestConfig.class, System.getenv(), System.getProperties());

    @Key("browser")
    String browser();

    @Key("baseUrl")
    String baseUrl();

    @Key("remote")
    boolean remote();

    @Key("remoteUrl")
    String remoteUrl();
}