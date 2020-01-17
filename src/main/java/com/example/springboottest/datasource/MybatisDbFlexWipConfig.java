package com.example.springboottest.datasource;


import com.github.pagehelper.PageInterceptor;
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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.example.springboottest.mapper.flex",sqlSessionFactoryRef = "flexSqlSessionFactory")
public class MybatisDbFlexWipConfig {

   // static final String PACKAGE = "com.example.springboottest.sqlServermapper";

    @Bean(name = "flexDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.flexwip")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "flexSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("flexDataSource") DataSource dataSource) throws Exception{
        final SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();

//        factoryBean.setTypeAliasesPackage("com.example.springboottest.sqlserverpo");
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect","oracle");
        properties.setProperty("reasonable","false");
        //properties.setProperty("supportMethodsArguments","true");
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        interceptor.setProperties(properties);
        factoryBean.setPlugins(new Interceptor[]{interceptor});
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*Mapper.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "flexTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("flexDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "flexSqlSessionTemplate")
    public SqlSessionTemplate sqlServerSqlSessionTemplate(
            @Qualifier("flexSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}














