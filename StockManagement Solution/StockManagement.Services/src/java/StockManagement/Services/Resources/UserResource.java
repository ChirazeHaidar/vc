/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.UserController;
import StockManagement.ObjectModel.ObjectInterface.IUser;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Mike Rmaily
 */
@Path("User")
public class UserResource {

    IUser _controller;

    public UserResource() {
        _controller = new UserController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<User> getAll() {
        return _controller.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/branch/{brCode}")
    public List<User> getByBranch(@PathParam("brCode") int brCode) {
        return _controller.getByBranch(brCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{usrCode}")
    public User get(@PathParam("usrCode") int usrCode) {
        return _controller.get(usrCode);
    }
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllRoles")
    public List<Role> getAllRoles() {
        return _controller.getAllRoles();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/roles/{usrCode}")
    public List<Role> getRoles(@PathParam("usrCode") int usrCode) {
        try{
        return _controller.getRoles(usrCode);
         }catch (Exception ex){
           System.out.println(ex);
       }
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actions/{usrCode}")
    public List<Action> getAllowedActions(@PathParam("usrCode") int usrCode) {
        return _controller.getAllowedActions(usrCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getAllowedActions")
    public List<Action> getAllowedActions(User user) {
        return _controller.getAllowedActions(user);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllowedActionsByBranch")
    public List<Action> getAllowedActionsByBranch(UserBranch userBranch) {
        return _controller.getAllowedActions(userBranch);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public User login(User user) {
        return _controller.login(user);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(User user) {
        return _controller.add(user);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(User user) {
        return _controller.update(user);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(User user) {
        return _controller.delete(user);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteById")
    public boolean delete(int usrCode) {
        return _controller.delete(usrCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/assignRole")
    public boolean assignRole(UserRole userRole) {
        return _controller.assignRole(userRole);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/removeRole")
    public boolean removeRole(UserRole userRole) {
        return _controller.removeRole(userRole);
    }
    
//     @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/code/{roCode}")
//    public Role getRole(@PathParam("roCode") int roCode) {
//        return _controller.getRole(roCode);
//    }
//       
}
