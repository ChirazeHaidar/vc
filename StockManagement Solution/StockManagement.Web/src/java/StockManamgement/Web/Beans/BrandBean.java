/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Brand;
import StockManagement.ObjectModel.ValueObject.Product;
import StockManagement.Services.brandClient;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "brandBean")
@ViewScoped
public class BrandBean implements Serializable {

    private String BrandName;
    private Integer BrandCode;
    private Product newProduct;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> Products) {
        this.products = Products;
    }
     
    public Product getNewProduct() {
        return newProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
    private Product selectedProduct;
      
    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }
   
      
    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public Integer getBrandCode() {
        return BrandCode;
    }

    public void setBrandCode(Integer BrandCode) {
        this.BrandCode = BrandCode;
    }

    private Brand selectedBrand;
    private List<Brand> brands;

    @ManagedProperty("#{brandClient}")
     private transient brandClient service;

    @PostConstruct
    public void init() {
          refreshData();
    }

    private void refreshData() {
        GenericType<List<Brand>> gType = new GenericType<List<Brand>>() {
        };
        brands = service.getAll(gType);
    }

    public void setService(brandClient service) {
        this.service = service;
    }

    public void add() {
        Brand newBrand = new Brand();
        newBrand.setBrdName(getBrandName());
        newBrand.setBrdCode(getBrandCode());
        newBrand.setBrdStatus(true);
        newBrand.setBrdCreationDate(Calendar.getInstance().getTime());
        service.add(newBrand, String.class);
        refreshData();
        MessageView.Info("Info", "Brand saved successfully.");
    }

    /**
     * @return the companies
     */
    public List<Brand> getBrands() {
        return brands;
    }

    /**
     * @return the selectedBrand
     */
    public Brand getSelectedBrand() {
        return selectedBrand;
    }

    /**
     * @param selectedBrand the selectedBrand to set
     */
    public void setSelectedBrand(Brand selectedBrand) {
        this.selectedBrand = selectedBrand;
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("selectedBrand", selectedBrand);
    }
    public void update() {
        service.update(selectedBrand, String.class);
        refreshData();
        MessageView.Info("Info", "Brand updated successfully.");
    }
     
        public void delete() {
        service.delete(selectedBrand.getBrdCode(), String.class);
        refreshData();
        MessageView.Info("Info", "Brand " + selectedBrand.getBrdName()+ " deleted successfully.");
    }
        
        
        public void addProduct() {
        newProduct.setBrand(selectedBrand);
        service.addProduct(newProduct, String.class);
        MessageView.Info("Info", "Product saved successfully.");
    }

    public void updateProduct() {
        selectedProduct.setBrand(selectedBrand);
        service.updateProduct(selectedProduct, String.class);
        MessageView.Info("Info", "Product updated successfully.");
    }

    public void deleteProduct() {
        service.deleteProduct(selectedProduct.getPrCode(), String.class);
        MessageView.Info("Info", "Product deleted successfully.");
    }
    
       public void onRowSelect(SelectEvent event) {
       if (event != null){
          Integer BrdCode = ((Brand) event.getObject()).getBrdCode();
        GenericType<List<Product>> gType = new GenericType<List<Product>>() {};
       products = service.getProducts(gType, BrdCode);
        setProducts(products);
    }
     
   
        
}
}