package academy.learnprogramming.config;

import academy.learnprogramming.util.Views;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "academy.learnprogramming")
public class WebConfig implements WebMvcConfigurer {

    // == constants ==
    public static final String RESOLVER_PREFIX_FOLDER_NAME = "/WEB-INF/view/";
    public static final String RESOLVER_SUFFIX_JSP_EXTENSION = ".jsp";

    // == bean methods ==

    @Bean
    public ViewResolver viewResolver() {
        /*
            If there is a JSTL on the classpath,
            InternalResourceViewResolver will automatically enable JSTL
         */
        UrlBasedViewResolver viewResolver
                = new InternalResourceViewResolver();

        viewResolver.setPrefix(RESOLVER_PREFIX_FOLDER_NAME);
        viewResolver.setSuffix(RESOLVER_SUFFIX_JSP_EXTENSION);
        return viewResolver;
    }

    /*
        WebMvcConfigurer interface has some default methods we can implement
        to customize our configuration, one of the methods is add view controllers
     */

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        /*
            configure simple automated controllers that are
            pre-configured with a response status code or a view to render the response body
            so in this case we're going to use a view
            simply put we configure in the path to the home view and
            spring will use it without having to create a controller
         */

        //http://localhost:8080/todo-list/
        registry.addViewController("/").setViewName(Views.HOME_VIEW);
    }
}