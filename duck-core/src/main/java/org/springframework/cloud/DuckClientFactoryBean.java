package org.springframework.cloud;

/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Spencer Gibb
 * @author Venil Noronha
 * @author Eko Kurniawan Khannedy
 * @author Gregor Zurowski
 */

@Data
class DuckClientFactoryBean
        implements FactoryBean<Object>, InitializingBean, ApplicationContextAware {

    /***********************************
     * WARNING! Nothing in this class should be @Autowired. It causes NPEs because of some
     * lifecycle race condition.
     ***********************************/

    private Class<?> type;

    private String name;

    private String url;

    private String contextId;

    private String path;

    private boolean decode404;

    private ApplicationContext applicationContext;

    private Class<?> fallback = void.class;

    private Class<?> fallbackFactory = void.class;

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.hasText(this.contextId, "Context id must be set");
        Assert.hasText(this.name, "Name must be set");
    }


    @Override
    public Object getObject() throws Exception {

        return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{this.getType()}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method = " + method.getName());
                return "hello";
            }
        });
    }

    @Override
    public Class<?> getObjectType() {
        return this.type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        this.applicationContext = context;
    }
}
