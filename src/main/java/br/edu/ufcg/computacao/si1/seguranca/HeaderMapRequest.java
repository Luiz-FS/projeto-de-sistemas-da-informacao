package br.edu.ufcg.computacao.si1.seguranca;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * Created by luiz on 24/03/17.
 */
public class HeaderMapRequest extends HttpServletRequestWrapper {

    private Map<String, String> headerMap;

    public HeaderMapRequest(HttpServletRequest request) {
        super(request);
        this.headerMap = new HashMap<>();
    }

    public void addHeader(String name, String value) {
        this.headerMap.put(name, value);
    }

    @Override
    public String getHeader(String name) {

        String headerValue = super.getHeader(name);

        if(this.headerMap.containsKey(name)) {
            headerValue = this.headerMap.get(name);
        }

        return headerValue;
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> names = Collections.list(super.getHeaderNames());
        for (String name : headerMap.keySet()) {
            names.add(name);
        }
        return Collections.enumeration(names);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> values = Collections.list(super.getHeaders(name));
        if (headerMap.containsKey(name)) {
            values.add(headerMap.get(name));
        }
        return Collections.enumeration(values);
    }

}
