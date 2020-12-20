package org.springframework.duck;

import lombok.Data;
import org.springframework.cloud.context.named.NamedContextFactory;


@Data
public class DuckClientSpecification implements NamedContextFactory.Specification{

    private String name;

    private Class<?>[] configuration;

    DuckClientSpecification() {
    }

    DuckClientSpecification(String name, Class<?>[] configuration) {
        this.name = name;
        this.configuration = configuration;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Class<?>[] getConfiguration() {
        return new Class[0];
    }
}
