package com.shaw.phisher.configurations;

import com.shaw.phisher.utils.Operations;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String active = Operations.readActiveFile();
        String[] CLASSPATH_RESOURCE_LOCATIONS;
        if (active == null) {
            CLASSPATH_RESOURCE_LOCATIONS =
                    new String[]{
                            "classpath:/META-INF/resources/", "classpath:/resources/",
                            "classpath:/static/", "classpath:/public/", "classpath:/static/vendor/", "classpath:/static/custom/"
                    };
        } else {
            CLASSPATH_RESOURCE_LOCATIONS =
                    new String[]{
                            "classpath:/META-INF/resources/", "classpath:/resources/",
                            "classpath:/" + active + "/", "classpath:/public/", "classpath:/static/vendor/", "classpath:/static/custom/"
                    };
        }

        registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
