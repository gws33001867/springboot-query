package com.example.springboottest.datasource;

import com.github.pagehelper.PageInterceptor;
import io.lettuce.core.dynamic.annotation.Value;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.example.springboottest.mapper.sqlserver",sqlSessionFactoryRef = "sqlServerSqlSessionFactory")
public class MybatisDbOtherConfig {

   // static final String PACKAGE = "com.example.springboottest.sqlServermapper";

    @Bean(name = "sqlServerDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.other")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlServerSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("sqlServerDataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
//        factoryBean.setTypeAliasesPackage("com.example.springboottest.sqlserverpo");

        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","sqlserver2012");
        properties.setProperty("reasonable","true");
        properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("autoRuntimeDialect","true");
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
        interceptor.setProperties(properties);
        factoryBean.setPlugins(new Interceptor[]{interceptor});
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*Mapper.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "sqlServerTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("sqlServerDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlServerSqlSessionTemplate")
    public SqlSessionTemplate sqlServerSqlSessionTemplate(
            @Qualifier("sqlServerSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}














