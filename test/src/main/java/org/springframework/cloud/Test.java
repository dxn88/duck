package org.springframework.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Nacos starter.
 *
 * @author nacos
 */
@SpringBootApplication
@EnableDuckClients
public class Test {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(Test.class, args);
//        final OrderProviderClient bean = run.getBean(OrderProviderClient.class);
//        final String configName = bean.getConfigName();
//        System.out.println("configName = " + configName);

    }
}
