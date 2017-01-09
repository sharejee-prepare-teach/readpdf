package com.javabycode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

import com.javabycode.view.ItextPdfView;
import com.javabycode.view.XlsView;
import com.javabycode.view.XlsxStreamingView;
import com.javabycode.view.XlsxView;

@EnableWebMvc
@Configuration
@ComponentScan("com.javabycode")
public class MyWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .defaultContentType(MediaType.TEXT_HTML)
                .parameterName("type")
                .favorParameter(true)
                .ignoreUnknownPathExtensions(false)
                .ignoreAcceptHeader(false)
                .useJaf(true);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        registry.enableContentNegotiation(
                new XlsView(),
                new XlsxView(),
                new XlsxStreamingView(),
        		new ItextPdfView());
    }
    
}
