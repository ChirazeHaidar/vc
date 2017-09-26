/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import StockManagement.ObjectModel.MangeObject.BrandController;
import StockManagement.ObjectModel.ObjectInterface.IBrand;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author MikeRmaily
 */
@Path("Brand")
public class BrandResource {

    IBrand _controller;

    public BrandResource() {
        _controller = new BrandController();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Path("/all")
    public List<Brand> getAll() {
        List<Brand> brands = _controller.getAll();
        return brands;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/code/{brCode}")
    public Brand get(@PathParam("brCode") int brCode) {
        return _controller.get(brCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public int add(Brand brand) {
        return _controller.add(brand);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public boolean update(Brand brand) {
        return _controller.update(brand);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/delete")
    public boolean delete(int brandCode) {
        return _controller.delete(brandCode);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/updateProduct")
    public boolean updateProduct(Product Product) {
        return _controller.updateProduct(Product);
    }

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/deleteProductById")
    public boolean deleteProduct(int PrCode) {
        return _controller.deleteProduct(PrCode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addProduct")
    public int addProduct(Product Product) {
        return _controller.addProduct(Product);
    }
   
    
    
    
    @GET
    
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/products/{BrdCode}")
    public List<Product> getProducts(@PathParam("BrdCode") int BrdCode) {
    
        List<Product> Products = _controller.getProducts(BrdCode);
        if (Products == null || Products.isEmpty()) {
            return null;
        }
        List<Product> newList = new ArrayList();
        for (int i = 0; i < Products.size(); i++) {
            Product original = Products.get(i);
            Product copy = new Product();
            copy.setPrCode(original.getPrCode());
            copy.setPrName(original.getPrName());
            copy.setCostPrice(original.getCostPrice());
            copy.setSellingPrice(original.getSellingPrice());
            copy.setPrStatus(original.isPrStatus());
            newList.add(copy);
        }
        return newList;
    }
    
    
 
     
    
       
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/products/{brdCode}")
//    public List<Product> getProducts(@PathParam("brdCode") int brdCode) {
//        return _controller.getProducts(brdCode);
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/deleteById")
//    public boolean delete(int brdCode) {
//        return _controller.delete(brdCode);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/addProduct")
//    public int addProduct(Product product) {
//        return _controller.addProduct(product);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/deleteProduct")
//    public boolean deleteProduct(Product product) {
//        return _controller.deleteProduct(product);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/deleteProductById")
//    public boolean deleteProduct(int prCode) {
//        return _controller.deleteProduct(prCode);
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/updateProduct")
//    public boolean updateProduct(Product product) {
//        return _controller.updateProduct(product);
//    }

}
