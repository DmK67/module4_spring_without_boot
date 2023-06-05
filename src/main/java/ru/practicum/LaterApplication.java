package ru.practicum;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class LaterApplication {
    private static final int PORT = 8080;

    public static void main(String[] args) throws LifecycleException {
        /* пока что тут пусто */
        Tomcat tomcat = new Tomcat();
        tomcat.getConnector().setPort(PORT);

        Context tomcatContext = tomcat.addContext("", null);

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.setServletContext(tomcatContext.getServletContext());
        applicationContext.scan("ru.practicum");
        applicationContext.refresh();

        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        Wrapper dispatcherWrapper = Tomcat.addServlet(tomcatContext, "dispatcher", dispatcherServlet);
        dispatcherWrapper.addMapping("/");
        dispatcherWrapper.setLoadOnStartup(1);

//        Wrapper testServletWrapper = Tomcat.addServlet(tomcatContext, "testServlet", new TestServlet());
//        testServletWrapper.addMapping("/test");

        tomcat.start();
    }
}
