package br.com.lucasmancan.medtech.api.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
public class EnvConfig {

    @Autowired
    Environment environment;

    @Value("${application.front-url}")
    private String frontUrl;

    private String port;

    private String hostname;

    public String getPort() {
        if (port == null) port = environment.getProperty("local.server.port");
        return port;
    }

    public Integer getPortAsInt() {
        return Integer.valueOf(getPort());
    }

    public String getHostname() {
        if (hostname == null) {
            try {
                hostname = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                hostname = "";
            }
        }
        return hostname;
    }

    public String getServerUrl() {
        return "http://" + getHostname() + ":" + getPort();
    }

    public String getFrontUrl() {
        return frontUrl;
    }
}