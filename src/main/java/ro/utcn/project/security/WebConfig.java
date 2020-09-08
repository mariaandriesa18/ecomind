package ro.utcn.project.security;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {
        "ro.utcn.project.controller"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean =
                new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix(".jsp");
        return bean;
    }
}