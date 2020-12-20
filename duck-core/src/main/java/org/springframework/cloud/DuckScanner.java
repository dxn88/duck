package org.springframework.cloud;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.TypeFilter;

public class DuckScanner extends ClassPathScanningCandidateComponentProvider {

    public DuckScanner() {
        super(false);
    }

    public DuckScanner(boolean useDefaultFilters) {
        super(useDefaultFilters);
    }

    public DuckScanner(boolean useDefaultFilters, Environment environment) {
        super(useDefaultFilters, environment);

    }

    public DuckScanner(boolean useDefaultFilters, Environment environment, TypeFilter typeFilter) {
        super(useDefaultFilters, environment);
        super.addIncludeFilter(typeFilter);

    }

    public DuckScanner(boolean useDefaultFilters, Environment environment, TypeFilter typeFilter, ResourceLoader classLoader) {
        super(useDefaultFilters, environment);
        super.addIncludeFilter(typeFilter);
        super.setResourceLoader(classLoader);
    }


    /**
     * 覆盖默认方法，默认方法只能是实体或者抽象class方法上有Lookup.class.name
     * 覆盖之后可以扫描到我们自己想要的类
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        final AnnotationMetadata metadata = beanDefinition.getMetadata();

        return metadata.isIndependent() && !metadata.isAnnotation();
    }

}
