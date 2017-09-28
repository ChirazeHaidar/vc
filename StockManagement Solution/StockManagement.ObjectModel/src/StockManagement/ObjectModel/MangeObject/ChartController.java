/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IChart;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
/**
 *
 * @author MikeRmaily
 */
public class ChartController implements IChart {

    private SessionFactory _sessionFactory;
    private Session _session;

    public ChartController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    @Override
    public List<Chart> GetProductsOrders() {
        try{
        List<Object[]> Orders = _session.createSQLQuery(" SELECT \n" +
"        p.PrCode AS prcode,\n" +
"        p.PrName AS prname,\n" +
"        COUNT(o.OrdCode) AS OrdersCount,\n" +
"        SUM(p.CostPrice) AS CostPrice,\n" +
"        SUM(p.SellingPrice) AS SellingPrice\n" +
"    FROM\n" +
"        Product p\n" +
"        JOIN `Order` o ON\n" +
"        p.PrCode = o.PrCode\n" +
"    GROUP BY p.PrCode").addScalar("prcode", StandardBasicTypes.INTEGER ).addScalar("prname", StandardBasicTypes.STRING).addScalar("OrdersCount", StandardBasicTypes.INTEGER).addScalar("CostPrice", StandardBasicTypes.FLOAT).addScalar("SellingPrice", StandardBasicTypes.FLOAT).list();
                
        if (null == Orders || Orders.isEmpty()) {
            return null;
        }
         List<Chart> ProductsOrders = new ArrayList<>();
         for (Object[] record : Orders){

            Chart chart = new Chart();
            Integer ProductCode = ((Integer) record[0]);
            chart.setPrCode(ProductCode);
            chart.setPrName((String) record[1]);
            Integer OrderCount = ((Integer) record[2]);
            chart.setOrders(OrderCount);
            chart.setCostPrice((float) record[3]);
            chart.setSellingPrice((float) record[4]);
            ProductsOrders.add(chart);
        }
         
        return ProductsOrders;
        }catch(Exception Ex){
      System.err.println("Caught Exception: " + Ex.getMessage());
    }
        return null;
    }
   
    
}
