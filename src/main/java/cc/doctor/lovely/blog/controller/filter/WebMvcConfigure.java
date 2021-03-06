package cc.doctor.lovely.blog.controller.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebMvcConfigure extends WebMvcConfigurationSupport {

    @Autowired
    private AuthFilter authFilter;

    @Autowired
    private LoggedInterceptor loggedInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authFilter)
                .excludePathPatterns("/index", "/login", "/doLogin", "/signUp",
                        "/assets/**", "/static/**", "*.html");
        registry.addInterceptor(loggedInterceptor);
        super.addInterceptors(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //设置启动的时候显示首页
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/");
        super.addResourceHandlers(registry);
    }


}
