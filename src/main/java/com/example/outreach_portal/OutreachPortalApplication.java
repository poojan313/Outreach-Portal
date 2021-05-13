package com.example.outreach_portal;

import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.outreach_portal.bean.User;
import com.example.outreach_portal.bean.project_tag;
import com.example.outreach_portal.dao.ProfileDao;
import com.example.outreach_portal.service.Implementation.ProfileServiceImplementation;

import javax.sql.DataSource;

@SpringBootApplication
public class OutreachPortalApplication {


	@Autowired
	ProfileDao profileDao;

	public static void main(String[] args) {

		SpringApplication.run(OutreachPortalApplication.class, args);
	}

	@Bean
	public DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		String url = System.getenv("DATABASE_HOST");
		if(url !=null){
			dataSourceBuilder.url("jdbc:mysql://outreach-db:3306/outreach_portal?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");
		}else{
			dataSourceBuilder.url("jdbc:mysql://localhost:3306/outreach_portal");
		}
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("poojankhatri");
		return dataSourceBuilder.build();
	}


	@Bean
	public ApplicationRunner sendDatabase() {
		return args -> {
			profileDao.save(new User(100, "sujit.kumar@iiitb.org", "12345678", false, "https://firebasestorage.googleapis.com/v0/b/outreach-portal-8d2c2.appspot.com/o/sujit.png?alt=media&token=8f17c7a9-1601-40e7-bdd2-d1b8b438b47f", "Sujit Kumar",
					"Mtech", "MT2020106", "2020", "", "", 1));
			profileDao.save(new User(101, "poojan.khatri@iiitb.org", "12345678", false, "https://firebasestorage.googleapis.com/v0/b/outreach-portal-8d2c2.appspot.com/o/poojan.png?alt=media&token=3b923b54-6cca-4ca7-97ca-08bc8ef6a6c9", "Poojan Khatri",
					"Mtech", "MT2020041", "2020", "", "", 1));
			profileDao.save(new User(102, "chandrika.bhuyan@iiitb.org", "12345678", false, "https://firebasestorage.googleapis.com/v0/b/outreach-portal-8d2c2.appspot.com/o/chandrika.png?alt=media&token=ff92fe45-fc25-4035-a994-429cf31e7a23", "Chandrika Bhuyan",
					"Mtech", "MT2020056", "2020", "", "", 1));

			profileDao.save(new User(103, "abc@iiitb.org", "12345678", true, "https://firebasestorage.googleapis.com/v0/b/outreach-portal-8d2c2.appspot.com/o/abc.png?alt=media&token=11511c26-c594-4d2f-9b41-bdd2a2e17ca9", "Abc",
					"", "", "", "", "", 1));

		};
	}
}

