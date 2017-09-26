/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Your Name <Mike Rmaily>
 */
@Provider
public class DebugExceptionMapper {
    public Response toResponse(Exception exception) {
        return Response.serverError().entity(exception.getMessage()).build();
    }  
}
