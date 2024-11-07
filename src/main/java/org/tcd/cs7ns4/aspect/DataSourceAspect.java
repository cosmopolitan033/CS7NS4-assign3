package org.tcd.cs7ns4.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.tcd.cs7ns4.config.DynamicRoutingDataSource;

@Aspect
@Component
public class DataSourceAspect {

    @Around("@annotation(org.tcd.cs7ns4.annotation.ReadOnly)")
    public Object setReadOnlyDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            DynamicRoutingDataSource.setDataSourceKey("replica");
            return joinPoint.proceed();
        } finally {
            DynamicRoutingDataSource.clearDataSourceKey();
        }
    }

    @Around("execution(* org.tcd.cs7ns4.repository.*.save*(..)) || execution(* org.tcd.cs7ns4.repository.*.delete*(..))")
    public Object setMasterDataSource(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            DynamicRoutingDataSource.setDataSourceKey("master");
            return joinPoint.proceed();
        } finally {
            DynamicRoutingDataSource.clearDataSourceKey();
        }
    }
}
