/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.SupplierController;
import StockManagement.ObjectModel.ObjectInterface.ISupplier;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author Elie
 */
@Path("Supplier")
public class SupplierResource {

    ISupplier _controller;
    public SupplierResource() {
      _controller = new SupplierController();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/code/{supCode}")
    public Supplier get(@PathParam("supCode")  int supCode) {
      return _controller.get(supCode);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Supplier> getAll() {
     return _controller.getAll();
    }

   @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{supCode}")
    public List<Product> getProducts(@PathParam("supCode")  int supCode) {
       return _controller.getProducts(supCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Supplier supplier) {
       return _controller.add(supplier);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Supplier supplier) {
       return _controller.update(supplier);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(Supplier supplier) {
       return _controller.delete(supplier);
    }

   @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteById")
    public boolean delete(int supCode) {
       return _controller.delete(supCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addProduct")
    public int addProduct( Product product) {
      return _controller.addProduct(product);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteProduct")
    public boolean deleteProduct(Product product) {
     return _controller.deleteProduct(product);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteProductById")
    public boolean deleteProduct(int prCode) { 
       return _controller.deleteProduct(prCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/updateProduct")
    public boolean updateProduct(Product product) {
     return _controller.updateProduct(product);
    }
    
    
    
}
