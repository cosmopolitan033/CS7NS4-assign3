package org.tcd.cs7ns4.config;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.jdbc.DataSourceBuilder;

@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Primary
    @Bean(name = "dataSource")
    public DynamicRoutingDataSource dataSource() {
        DynamicRoutingDataSource routingDataSource = new DynamicRoutingDataSource();

        DataSource masterDataSource = DataSourceBuilder.create()
                .url(dataSourceProperties.getMaster().getUrl())
                .username(dataSourceProperties.getMaster().getUsername())
                .password(dataSourceProperties.getMaster().getPassword())
                .driverClassName(dataSourceProperties.getMaster().getDriverClassName())
                .build();

        DataSource replicaDataSource = DataSourceBuilder.create()
                .url(dataSourceProperties.getReplica().getUrl())
                .username(dataSourceProperties.getReplica().getUsername())
                .password(dataSourceProperties.getReplica().getPassword())
                .driverClassName(dataSourceProperties.getReplica().getDriverClassName())
                .build();

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", masterDataSource);
        targetDataSources.put("replica", replicaDataSource);

        routingDataSource.setTargetDataSources(targetDataSources);
        routingDataSource.setDefaultTargetDataSource(masterDataSource); // 默认数据源为主库

        return routingDataSource;
    }
}
