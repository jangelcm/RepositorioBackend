package pe.com.targethr.authserver.config.filter;

import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class FiltersConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public FilterRegistrationBean<CorsFilter> customCorsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.applyPermitDefaultValues();
        corsConfig.setAllowedMethods(Collections.singletonList("*"));
        corsConfig.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(-100);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<MinifiyResponseFilter> customResponseFilter() {
        MinifiyResponseFilter filter = new MinifiyResponseFilter(objectMapper);
        FilterRegistrationBean<MinifiyResponseFilter> bean = new FilterRegistrationBean<>(filter);
        bean.setOrder(-99);
        bean.addUrlPatterns("/oauth/token");
        return bean;
    }
}