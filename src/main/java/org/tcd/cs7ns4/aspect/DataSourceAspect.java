package org.tcd.cs7ns4.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.tcd.cs7ns4.config.DynamicRoutingDataSource;

@Aspect
@Component
public class DataSourceAspect {

    @Before("@annotation(org.tcd.cs7ns4.annotation.ReadOnly)")
    public void setReplicaDataSource() {
        DynamicRoutingDataSource.setDataSourceKey("replica");
    }

    @Before("execution(* org.tcd.cs7ns4..*(..)) && !@annotation(org.tcd.cs7ns4.annotation.ReadOnly)")
    public void setMasterDataSource() {
        DynamicRoutingDataSource.setDataSourceKey("master");
    }
}
