/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.MenuController;
import StockManagement.ObjectModel.ObjectInterface.IMenu;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikeRmaily
 */
@Path("Menu")
public class MenuResource {

    IMenu _controller;

    public MenuResource() {
        _controller = new MenuController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Menu> getAll() {
        List<Menu> Menus = _controller.getAll();
        return Menus;
    }

  
}
