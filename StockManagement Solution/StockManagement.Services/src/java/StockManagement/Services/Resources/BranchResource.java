/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.BranchController;
import StockManagement.ObjectModel.ObjectInterface.IBranch;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Firas
 */
@Path("Branch")
public class BranchResource {

    IBranch _controller;

    public BranchResource() {
        _controller = new BranchController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Branch getAll() {
        return null;
        // throw (new Exception("Not implemented exception"));
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{brCode}")
    public Branch get(@PathParam("brCode") int brCode) {
        return _controller.get(brCode);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getByCompany/{compCode}")
    public List<Branch> getByCompany(@PathParam("compCode") int compCode) {
         List<Branch> branches =   _controller.getByCompany(compCode);
        if ( null == branches || branches.isEmpty())
            return null;
        List<Branch> list = new ArrayList();
        for(int i=0;i<branches.size();i++)
        {
            Branch original = branches.get(i);
            Branch copy = new Branch();
            /*copy.setDestination(original.getDestination());
            copy.setOrdCode(original.getOrdCode());
            copy.setOrdDate(original.getOrdDate());
            copy.setOrdDestination(original.getOrdDestination());
            copy.setOrdQty(original.getOrdQty());
            copy.setPrCode(original.getPrCode());
            copy.setOrdSource(original.getOrdSource());
            copy.setSource(original.getSource());*/
            copy.setBrCode(original.getBrCode());
            copy.setBrName(original.getBrName());
            list.add(copy);
        }
        return list;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Branch branch) {
        return _controller.add(branch);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(Branch branch) {
        return _controller.delete(branch);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteById")
    public boolean delete(int brCode) {
        return _controller.delete(brCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Branch branch) {
        return _controller.update(branch);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/assignRole")
    public boolean assignRole(RoleBranch roleBranch) {
        return _controller.assignRole(roleBranch);
    }

     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/removeRole")
    public boolean removeRole(RoleBranch roleBranch) {
        return _controller.removeRole(roleBranch);
    }

    
    /*@GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getRoles")
    public List<Role> getRoles(Branch branch) {
        return _controller.getRoles(branch);
    }*/

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/roles/{brCode}")
    public List<Role> getRoles(@PathParam("brCode") int brCode) {
       return _controller.getRoles(brCode);
    }

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/excludedRoles/{brCode}")
    public List<Role> getExcludedRoles(@PathParam("brCode") int brCode) {
       return _controller.getExcludedRoles(brCode);
    }
    
}
