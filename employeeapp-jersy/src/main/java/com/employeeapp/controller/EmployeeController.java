package com.employeeapp.controller;

import com.employeeapp.entities.Employee;
import com.employeeapp.service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.sql.ast.tree.from.StandardTableGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//api/employees
//api/query?message=java
@Path("api")
@Log4j2
public class EmployeeController {

    private  EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //get all
    @GET
    @Produces("application/json")
    @Path("/employees")
    public List<Employee> getAll(){
        if(1==1)
            throw new RuntimeException("some db ex");
        return employeeService.getAll();
    }
    //get by id
    @GET
    @Produces("application/json")
    @Path("/employees/{id}")
    public Employee getByid(@PathParam("id")  int id){
        return employeeService.getById(id);
    }

    //add
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/employees")
    public Response addEmployee(Employee employee){
        Employee employeeAdded= employeeService.addEmployee(employee);
        return Response.status(Response.Status.CREATED).entity(employeeAdded).build();
    }
    //delete
    @DELETE
    @Produces("application/json")
    @Path("/employees/{id}")
    public Response deleteByid(@PathParam("id")  int id){
        Employee employeeDeleted= employeeService.getById(id);
        log.info("employee deleted {}", employeeDeleted);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    //update
    @PUT
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/employees/{id}")
    public Response updateByid(@PathParam("id")  int id, Employee employee){
        Employee employeeUpdated= employeeService.updateEmployee(id, employee);
        return Response.status(Response.Status.OK).entity(employeeUpdated).build();
    }



    //@PathParam vs @QueryParam

//    @GET
//    @Path("/{param}")
//    public Response getMessage(@PathParam("param") String message){
//        String data="demo of Pathparam "+ message;
//        return Response.status(200).entity(data).build();
//    }
//    @GET
//    @Path("/query")
//    public Response getMessageQueryParam(@QueryParam("message") String message){
//        String data="demo of Query param" +message;
//        return Response.status(200).entity(data).build();
//    }
}
