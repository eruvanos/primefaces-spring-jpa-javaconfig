package de.siemering.example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("de.siemering.example")
@EnableTransactionManagement
public class AppConfig {

    private static final Logger log = LogManager.getLogger("AppConfig.class");

    public AppConfig() {
        log.trace("AppConfig created");
    }

//    http://forum.spring.io/forum/spring-projects/container/45760-correct-usage-of-factorybeans-in-javaconfig
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        transactionManager.afterPropertiesSet();
        return transactionManager;
    }

    @Bean
    public EntityManagerFactory entityManagerFactoryFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPersistenceUnitName("pu");
        entityManagerFactoryBean.afterPropertiesSet();
        return entityManagerFactoryBean.getObject();
    }


}
