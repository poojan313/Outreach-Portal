package com.example.outreach_portal.datasources;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        String url = System.getenv("DATABASE_HOST");
        if(url !=null){
            dataSourceBuilder.url("jdbc:mysql://outreach-db:3306/outreach_portal?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
        }else{
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/outreach_portal?createDatabaseIfNotExist=true");
        }
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("poojankhatri");
        return dataSourceBuilder.build();
    }
}