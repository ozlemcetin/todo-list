package academy.learnprogramming.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/*
    to programmatically register the servlet we have to implement
    the web application initializer interface.

    the implementations of this interface will be automatically detected by spring
    upon startup of our application so to do that
*/

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    // == constants ==
    private static final String DISPATHCER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup()");

        //create web application context also knows as Spring container
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        //register web config class with application context
        context.register(WebConfig.class);

        /*
          create the dispatcher servlet - front controller
          it receives all of the requests for your application
         */
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        //register the dispatcher servlet with servlet context
        ServletRegistration.Dynamic servletRegistration =
                servletContext.addServlet(DISPATHCER_SERVLET_NAME, dispatcherServlet);

        //use ServletRegistration.Dynamic to configure the servlet
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }
}
