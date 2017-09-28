/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Chart;
import StockManagement.Services.ChartClient;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "ChartBean")
@ViewScoped
public class ChartBean implements Serializable {
    private List<Chart> ProductsOrders;
    private LineChartModel animatedModel1;
   private BarChartModel animatedModel2;
     private BarChartModel animatedModel3;
 
   public List<Chart> getProductsOrders() {
        return ProductsOrders;
    }

    public BarChartModel getAnimatedModel3() {
        return animatedModel3;
    }

    public void setAnimatedModel3(BarChartModel animatedModel3) {
        this.animatedModel3 = animatedModel3;
    }

    public void setProductsOrders(List<Chart> ProductsOrders) {
        this.ProductsOrders = ProductsOrders;
    }

    public ChartClient getService() {
        return service;
    }

    public void setService(ChartClient service) {
        this.service = service;
    }

 
    @ManagedProperty("#{ChartClient}")
     private transient ChartClient service;

    @PostConstruct
    public void init() {
          refreshData();
          
    }

    private void refreshData() {
        GenericType<List<Chart>> gType = new GenericType<List<Chart>>() {
        };
        ProductsOrders = service.GetProductsOrders(gType);
        
        if (! ProductsOrders.isEmpty()){
           createAnimatedModels();
          
        }
}
  
    public LineChartModel getAnimatedModel1() {
        return animatedModel1;
    }
 
    public BarChartModel getAnimatedModel2() {
        return animatedModel2;
    }
 
    private void createAnimatedModels() {

       animatedModel2 = initBarModel();
       animatedModel2.setTitle("Product Orders");
      animatedModel2.setAnimate(true);
        animatedModel2.setLegendPosition("ne");
         Axis  yAxis = animatedModel2.getAxis(AxisType.Y);
        yAxis.setMin(0);
       yAxis.setMax(10);
   
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries Orders = new ChartSeries();
        Orders.setLabel("Orders");
        for (Iterator<Chart> it = ProductsOrders.iterator(); it.hasNext();) {
            Chart Order = it.next();
            Orders.set(Order.getPrName(), Order.getOrders());
        }
        model.addSeries(Orders);         
        return model;
    }
    


}
