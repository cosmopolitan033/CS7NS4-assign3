package org.tcd.cs7ns4.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {

    private DataSourceConfig master;
    private DataSourceConfig replica;

    public DataSourceConfig getMaster() {
        return master;
    }

    public void setMaster(DataSourceConfig master) {
        this.master = master;
    }

    public DataSourceConfig getReplica() {
        return replica;
    }

    public void setReplica(DataSourceConfig replica) {
        this.replica = replica;
    }

    public static class DataSourceConfig {
        private String url;
        private String username;
        private String password;
        private String driverClassName;

        // Getters 和 Setters
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getDriverClassName() {
            return driverClassName;
        }

        public void setDriverClassName(String driverClassName) {
            this.driverClassName = driverClassName;
        }
    }
}
