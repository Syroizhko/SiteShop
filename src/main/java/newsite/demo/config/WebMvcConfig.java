package newsite.demo.config;


        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
        import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
        import org.springframework.web.servlet.resource.PathResourceResolver;

@EnableWebSecurity
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter implements WebMvcConfigurer {

    @Value("${file.path}")
    private String path;

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/login").setViewName("login");
    }

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/src/main/webapp/resources/css/**")
            .addResourceLocations("/resources/css/");
    registry.addResourceHandler("/images/**").addResourceLocations("file:"+path).setCachePeriod(Integer.MAX_VALUE);
    super.addResourceHandlers(registry);

}
}
