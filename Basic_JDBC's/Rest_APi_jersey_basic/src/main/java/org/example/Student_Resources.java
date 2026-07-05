package org.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class Student_Resources {

    @GET
    @Produces(MediaType.APPLICATION_XML) // Back to XML
    public Students getStudent(){
        System.out.println("Success: XML Endpoint was touched!");
        Students s1 = new Students();
        s1.setName("sam");
        s1.setRollN (42);

        return s1;
    }
}