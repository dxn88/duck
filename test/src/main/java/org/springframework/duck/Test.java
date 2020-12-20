package org.springframework.duck;

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
        final ConfigurableApplicationContext run = SpringApplication.run(org.springframework.duck.TestCurrent.class, args);
        final OrderProviderClient bean = run.getBean(OrderProviderClient.class);
        final String configName = bean.getConfigName();
        System.out.println("configName = " + configName);

    }
}
