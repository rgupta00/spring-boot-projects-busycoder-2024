package com.employeeapp.excpetionmappers;

import com.employeeapp.dto.ErrorMessage;
import com.employeeapp.exceptions.ResourceNotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericExMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable e) {
        ErrorMessage errorMessage=ErrorMessage.builder().statusCode(500).message(e.getMessage())
                .toContact("rgupta.mtech@gmail.com").build();

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }
}
