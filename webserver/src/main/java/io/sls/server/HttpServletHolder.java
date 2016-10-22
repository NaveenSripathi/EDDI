package io.sls.server;

import lombok.Getter;

import javax.servlet.Servlet;
import java.util.HashMap;
import java.util.Map;

@Getter
public class HttpServletHolder {
    private Servlet servlet;
    private final String path;
    private Map<String, String> initParameter = new HashMap<>();

    public HttpServletHolder(Servlet servlet, String path) {
        this.servlet = servlet;
        this.path = path;
    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

    public void addInitParameter(String key, String value) {
        initParameter.put(key, value);
    }
}
