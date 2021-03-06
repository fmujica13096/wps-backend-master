package com.walmart.product.search;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@ConfigurationProperties(prefix = "mongodb")
public class MongoClientConfiguration   {

    @Bean
    public MongoClient mongo() throws Exception {
        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/promotions");
        //final ConnectionString connectionString = new ConnectionString("mongodb://productListUser:productListPassword@nameless-tor-21397.herokuapp.com:27017/promotions");
        //mongodb://<dbuser>:<dbpassword>@ds053148.mongolab.com:53148/<database name>');
        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "promotions");
    }
}