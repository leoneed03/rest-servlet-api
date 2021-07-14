package org.app.controller;

import org.app.model.Student;
import org.app.service.StudentService;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/students")
public class HelloServlet {

    private final StudentService studentService = new StudentService();

    @GET
    @Produces("application/json")
    public List<Student> getClichedMessage() {
        return studentService.getListOfStudents((long) 1).orElse(new ArrayList<>());
    }


    @GET
    @Path("/{value}")
    @Produces("application/json")
    public Student getStudent(
            @PathParam("value") final Long value
//            ,HttpServletResponse httpResponse
    ) {


        Optional<Student> studentOptional = studentService.getStudentOrEmpty(value);

        if (studentOptional.isPresent()) {
            return studentOptional.get();
        } else {

//            httpResponse.setStatus(401);
            return new Student();
        }
    }
}
