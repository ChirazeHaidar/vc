/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.ChartController;
import StockManagement.ObjectModel.ObjectInterface.IChart;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikeRmaily
 */
@Path("Chart")
public class ChartResource {

    IChart _controller;

    public ChartResource() {
        _controller = new ChartController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Chart> GetProductsOrders() {
        List<Chart> ProductsOrders = _controller.GetProductsOrders();
        return ProductsOrders;
    }

  
}
