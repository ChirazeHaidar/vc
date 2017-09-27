/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IMenu;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 *
 * @author MikeRmaily
 */
public class MenuController implements IMenu {

    private SessionFactory _sessionFactory;
    private Session _session;

    public MenuController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> Menus = _session.createQuery("From Menu").list();
        if (null == Menus || Menus.isEmpty()) {
            return null;
        }
        return Menus;
    }
   
    
}
