package io.sls.runtime;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import io.swagger.config.ScannerFactory;
import io.swagger.jaxrs.config.BeanConfig;
import org.jboss.resteasy.util.GetRestful;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.stream.Collectors;

/**
 * @author ginccc
 */
public class SwaggerServletContextListener implements ServletContextListener {
    private final Injector injector;

    @Inject
    SwaggerServletContextListener(Injector injector) {
        this.injector = injector;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        BeanConfig beanConfig = getBeanConfig();
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("scanner", ScannerFactory.getScanner());
        servletContext.setAttribute("swagger", beanConfig.getSwagger());
        servletContext.setAttribute("reader", beanConfig);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

    private BeanConfig getBeanConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setHost(getConfig("swagger.host"));
        beanConfig.setTitle(getConfig("swagger.title"));
        beanConfig.setVersion(getConfig("swagger.version"));
        beanConfig.setContact(getConfig("swagger.contact"));
        beanConfig.setLicense(getConfig("swagger.license"));
        beanConfig.setBasePath(getConfig("swagger.base_path"));
        beanConfig.setLicenseUrl(getConfig("swagger.licenseUrl"));
        beanConfig.setDescription(getConfig("swagger.description"));
        beanConfig.setPrettyPrint(getConfig("swagger.pretty_print"));
        beanConfig.setTermsOfServiceUrl(getConfig("swagger.terms_of_service_url"));

        // Must be called last
        beanConfig.setResourcePackage(resourcePackages());
        beanConfig.setScan(true);

        return beanConfig;
    }

    private String getConfig(String key) {
        return injector.getInstance(Key.get(String.class, Names.named(key)));
    }

    /**
     * Returns a comma separated list of resource packages.
     */
    private String resourcePackages() {
        return injector.getBindings().keySet().stream()
                .map(key -> key.getTypeLiteral().getRawType())
                .filter(GetRestful::isRootResource)
                .map(clazz -> clazz.getPackage().getName())
                .distinct()
                .collect(Collectors.joining(","));
    }
}