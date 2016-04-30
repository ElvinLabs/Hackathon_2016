package com.ajantha.base;

import com.ajantha.config.MongoConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by ajantha on 1/2/16.
 */
public class Base {

   public  ApplicationContext applicationContext;
   public  MongoTemplate mongoTemplate ;
   public  MongoOperations mongoOperations ;

    public  MongoTemplate getMongoTemplate(){
        applicationContext = new AnnotationConfigApplicationContext(MongoConfig.class);
        mongoTemplate = (MongoTemplate) applicationContext.getBean("mongoTemplate");
        return mongoTemplate;
    }


}
