package org.springframework.duck;


import lombok.Data;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        System.out.println("type = " + type);
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{this.getType()}, new InvocationHandler() {
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
