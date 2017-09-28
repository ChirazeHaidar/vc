/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services.Resources;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author mfaour
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(StockManagement.Services.Resources.ActionResource.class);
        resources.add(StockManagement.Services.Resources.BranchResource.class);
        resources.add(StockManagement.Services.Resources.BrandResource.class);
        resources.add(StockManagement.Services.Resources.ClientResource.class);
        resources.add(StockManagement.Services.Resources.CompanyResource.class);
        resources.add(StockManagement.Services.Resources.OrderResource.class);
        resources.add(StockManagement.Services.Resources.ProductResource.class);
        resources.add(StockManagement.Services.Resources.RoleResource.class);
        resources.add(StockManagement.Services.Resources.SupplierResource.class);
        resources.add(StockManagement.Services.Resources.UserResource.class);
         resources.add(StockManagement.Services.Resources.MenuResource.class);
         resources.add(StockManagement.Services.Resources.ChartResource.class);
    }
    
}
