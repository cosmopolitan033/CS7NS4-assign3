package org.tcd.cs7ns4.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(DataSource.class).build();
    }

    @Bean
    public DataSource replicaDataSource() {
        return DataSourceBuilder.create().type(DataSource.class).build();
    }

    @Bean
    @Primary
    public DataSource routingDataSource() {
        DynamicDataSource routingDataSource = new DynamicDataSource();
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("master", masterDataSource());
        dataSourceMap.put("replica", replicaDataSource());

        routingDataSource.setDefaultTargetDataSource(masterDataSource());
        routingDataSource.setTargetDataSources(dataSourceMap);

        return routingDataSource;
    }
}
