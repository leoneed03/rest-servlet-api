package org.app.controller;

import org.app.model.Student;
import org.app.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/students")
public class StudentsServlet {

    private static final StudentService studentService = new StudentService();

    @GET
    @Produces("application/json")
    public List<Student> getAllStudents() {

        System.out.println("GET ALL STUDENTS");
        return studentService.getListOfStudents();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getStudent(@PathParam("id") final Long id) {

        Optional<Student> studentOptional = studentService.getStudentOrEmpty(id);

        if (studentOptional.isPresent()) {

            return Response.status(Response.Status.OK)
                    .entity(studentOptional.get())
                    .build();
        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response saveStudent(Student student) {

        studentService.addStudent(student);

        return Response.status(Response.Status.CREATED).entity(student).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateStudent(@PathParam("id") final Long id,
                                  Student student) {
        student.setId(id);

        Optional<Student> studentFound = studentService.updateStudentIfExists(id, student);

        if (studentFound.isPresent()) {

            return Response.status(Response.Status.OK).entity(studentFound.get()).build();

        } else {

            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
