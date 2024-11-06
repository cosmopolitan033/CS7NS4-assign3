package org.tcd.cs7ns4.aspect;

import org.tcd.cs7ns4.annotation.ReadOnly;
import org.tcd.cs7ns4.config.DynamicDataSource;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAspect {

    @Before("@annotation(ReadOnly)")
    public void setReplicaDataSource() {
        DynamicDataSource.setDataSourceKey("replica");
    }

    @Before("!@annotation(ReadOnly)")
    public void setMasterDataSource() {
        DynamicDataSource.setDataSourceKey("master");
    }

    @After("execution(* *(..))")
    public void clearDataSource() {
        DynamicDataSource.clearDataSourceKey();
    }
}
