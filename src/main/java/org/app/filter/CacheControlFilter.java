package org.app.filter;

import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CacheControlFilter implements ContainerResponseFilter {
    public void filter(ContainerRequestContext req, ContainerResponseContext res)
            throws IOException
    {
        if (req.getMethod().equals("GET")) {
            System.out.println("GET CONTROL FILTER CACHE");
//            CacheControl cc = new CacheControl();
//            cc.setMaxAge(100);
//            req.getHeaders().add("Cache-Control", cc.toString());
        }
    }
}