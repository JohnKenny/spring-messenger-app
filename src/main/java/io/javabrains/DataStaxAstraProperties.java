package io.javabrains;

import java.io.File;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "datastax.astra")
public class DataStaxAstraProperties {

    private File secureConnectBunde;

    public File getSecureConnectBunde() {
        return secureConnectBunde;
    }

    public void setSecureConnectBunde(File secureConnectBunde) {
        this.secureConnectBunde = secureConnectBunde;
    }

    

}
