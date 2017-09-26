/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.RoleController;
import StockManagement.ObjectModel.ObjectInterface.IRole;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Firas
 */
@Path("Role")
public class RoleResource {

    IRole _controller;

    public RoleResource() {
        _controller = new RoleController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Role> getAll() {
        return _controller.getAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{roCode}")
    public Role get(@PathParam("roCode") int roCode) {
        return _controller.get(roCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getRoleUsers")
    public List<User> getUsers(Role role) {
        return _controller.getUsers(role);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users/{roCode}")
    public List<User> getUsers(@PathParam("roCode") int roCode) {
        return _controller.getUsers(roCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Role role) {
        return _controller.add(role);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Role role) {
        return _controller.update(role);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(Role role) {
        return _controller.delete(role);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteById")
    public boolean delete(int roCode) {
        return _controller.delete(roCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/assignToBranch")
    public boolean assignToBranch(RoleBranch roleBranch) {
        return _controller.assignToBranch(roleBranch);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/assignAction")
    public int assignAction(RoleAction roleAction) {
        return _controller.assignAction(roleAction);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getActions")
    public List<Action> getActions(Role role) {
        return _controller.getActions(role);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/actions/{roCode}")
    public List<Action> getActions(@PathParam("roCode") int roCode) {
        return _controller.getActions(roCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/removeAction")
    public boolean removeAction(RoleAction roleAction) {
        return _controller.removeAction(roleAction);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/assignUser")
    public boolean assignUser(UserRole userRole) {
        return _controller.assignUser(userRole);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/removeUser")
    public boolean removeUser(UserRole userRole) {
        return _controller.removeUser(userRole);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/removeFromBranch")
    public boolean removeFromBranch(RoleBranch roleBranch) {
        return _controller.removeFromBranch(roleBranch);
    }


}
