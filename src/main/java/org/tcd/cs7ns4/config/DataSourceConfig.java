package org.tcd.cs7ns4.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "org.tcd.cs7ns4.repository",
        entityManagerFactoryRef = "masterEntityManagerFactory",
        transactionManagerRef = "masterTransactionManager"
)
public class DataSourceConfig {

    // 主数据库的数据源
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        // 创建主数据源的配置
        return new HikariDataSource();
    }

    // 从数据库的数据源
    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        // 创建从数据源的配置
        return new HikariDataSource();
    }

    // 主数据源的EntityManagerFactory
    @Primary
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("masterDataSource") DataSource masterDataSource) {
        return builder
                .dataSource(masterDataSource)
                .packages("org.tcd.cs7ns4.entity")
                .persistenceUnit("master")
                .build();
    }

    // 从数据源的EntityManagerFactory
    @Bean(name = "slaveEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean slaveEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        return builder
                .dataSource(slaveDataSource)
                .packages("org.tcd.cs7ns4.entity")
                .persistenceUnit("slave")
                .build();
    }

    // 主数据库的事务管理器
    @Primary
    @Bean(name = "masterTransactionManager")
    public JpaTransactionManager masterTransactionManager(
            @Qualifier("masterEntityManagerFactory") LocalContainerEntityManagerFactoryBean masterEntityManagerFactory) {
        return new JpaTransactionManager(masterEntityManagerFactory.getObject());
    }

    // 从数据库的事务管理器
    @Bean(name = "slaveTransactionManager")
    public JpaTransactionManager slaveTransactionManager(
            @Qualifier("slaveEntityManagerFactory") LocalContainerEntityManagerFactoryBean slaveEntityManagerFactory) {
        return new JpaTransactionManager(slaveEntityManagerFactory.getObject());
    }
}
