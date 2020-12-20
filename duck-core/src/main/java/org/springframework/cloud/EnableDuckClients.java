package org.springframework.cloud;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(DuckClientsRegistrar.class)
public @interface EnableDuckClients {

    /**
     * basePackages别名，用于扫描路径
     */
    String[] value() default {};

    /**
     * 包下的所有类都扫描
     */
    String[] basePackages() default {};

    /**
     * 跟此类同一个包下的所有类
     */
    Class<?>[] basePackageClasses() default {};

    /**
     * 配置类
     */
    Class<?>[] defaultConfiguration() default {};

    /**
     * 被DuckClient标注的类
     */
    Class<?>[] ducks() default {};

}