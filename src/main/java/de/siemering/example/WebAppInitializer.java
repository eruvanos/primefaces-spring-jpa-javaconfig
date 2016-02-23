package de.siemering.example;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


public class WebAppInitializer implements WebApplicationInitializer {

    private static final Logger log = LogManager.getLogger(WebAppInitializer.class);


    public WebAppInitializer() {
        log.trace("Create WebAppInitializer");
    }

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();

        //Spring Context Config
        ctx.register(AppConfig.class);

        ctx.setServletContext(servletContext);

        servletContext.addListener(new ContextLoaderListener(ctx));
        servletContext.addListener(new RequestContextListener());

        Dynamic dynamic = servletContext.addServlet("faces-servlet", new FacesServlet());
        dynamic.addMapping("*.xhtml");
        dynamic.setLoadOnStartup(1);

   }
}  