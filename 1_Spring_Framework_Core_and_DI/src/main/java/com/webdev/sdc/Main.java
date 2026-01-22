package com.webdev.sdc;


import com.webdev.sdc.config.AppConfig;
import com.webdev.sdc.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Main {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        Connector connector = new Connector();
        connector.setPort(8080);
        tomcat.setConnector(connector);

        Context context = tomcat.addContext("", System.getProperty("java.io.tmpdir"));

        AnnotationConfigWebApplicationContext webContext =
                new AnnotationConfigWebApplicationContext();

        webContext.register(AppConfig.class, WebConfig.class);
        webContext.setServletContext(context.getServletContext());

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/", "dispatcher");

        tomcat.start();
        tomcat.getServer().await();
    }
}