/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.OrderController;
import StockManagement.ObjectModel.ObjectInterface.IOrder;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ali chreif
 */
@Path("Order")
public class OrderResource {

    IOrder _controller;

    public OrderResource() {
        _controller = new OrderController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAll() {
        List<Order> orders =  _controller.getAll();
        if ( null == orders || orders.isEmpty())
            return null;
        List<Order> list = new ArrayList();
        for(int i=0;i<orders.size();i++)
        {
            Order original = orders.get(i);
            Order copy = new Order();
            copy.setDestination(original.getDestination());
            copy.setOrdCode(original.getOrdCode());
            copy.setOrdDate(original.getOrdDate());
            copy.setOrdDestination(original.getOrdDestination());
            copy.setOrdQty(original.getOrdQty());
            copy.setPrCode(original.getPrCode());
            copy.setOrdSource(original.getOrdSource());
            copy.setSource(original.getSource());
            list.add(copy);
        }
        return list;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Order order) {
        return _controller.add(order);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Order order) {
        return _controller.update(order);
    }

   

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(int ordCode) {
        return _controller.delete(ordCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getBySource")
    public List<Order> getBySource(OrderRoute orderRoute) {
        return _controller.getBySource(orderRoute);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getByDestination")
    public List<Order> getByDestination(OrderRoute orderRoute) {
        return _controller.getByDestination(orderRoute);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getByCompany/{compCode}/{usrCode}")
    public List<Order> getByCompany(@PathParam("compCode") int compCode, @PathParam("usrCode") int usrCode) {
         List<Order> orders =   _controller.getByCompany(compCode,usrCode);
        if ( null == orders || orders.isEmpty())
            return null;
        List<Order> list = new ArrayList();
        for(int i=0;i<orders.size();i++)
        {
            Order original = orders.get(i);
            Order copy = new Order();
            copy.setDestination(original.getDestination());
            copy.setOrdCode(original.getOrdCode());
            copy.setOrdDate(original.getOrdDate());
            copy.setOrdDestination(original.getOrdDestination());
            copy.setOrdQty(original.getOrdQty());
            copy.setPrCode(original.getPrCode());
            copy.setOrdSource(original.getOrdSource());
            copy.setSource(original.getSource());
            list.add(copy);
        }
        return list;
    }
 
}
