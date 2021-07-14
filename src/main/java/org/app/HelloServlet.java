package org.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloServlet {

//    @GET
//    @Produces("text/plain")
//    public String getClichedMessage() {
//        return "Hello World HIIII";
//    }

    @GET
    @Produces("application/json")
    public InfoClass getClichedMessage() {
        return new InfoClass();
    }
}
