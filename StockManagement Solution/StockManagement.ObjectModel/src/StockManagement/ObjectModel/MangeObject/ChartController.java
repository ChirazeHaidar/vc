/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IChart;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        List<Chart> ProductsOrders = _session.createQuery("From ProductsOrders").list();
        if (null == ProductsOrders || ProductsOrders.isEmpty()) {
            return null;
        }
        return ProductsOrders;
    }
   
    
}
