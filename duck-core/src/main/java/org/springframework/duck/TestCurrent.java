package org.springframework.duck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
//@EnableDuckClients
public class TestCurrent {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(TestCurrent.class, args);
//        final OrderProviderClient bean = run.getBean(OrderProviderClient.class);
//        final String configName = bean.getConfigName();
//        System.out.println("configName = " + configName);

    }
}
