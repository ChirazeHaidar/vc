/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Menu;
import StockManagement.Services.MenuClient;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "MenuBean")
@ViewScoped
public class MenuBean implements Serializable {
    private List<Menu> Menus;
     private  DefaultMenuModel model;  

    public DefaultMenuModel getModel() {
        return model;
    }

    public void setModel(DefaultMenuModel model) {
        this.model = model;
    }
    public List<Menu> getMenus() {
        return Menus;
    }

    public void setMenus(List<Menu> Menus) {
        this.Menus = Menus;
    }
    @ManagedProperty("#{MenuClient}")
     private transient MenuClient service;

    @PostConstruct
    public void init() {
          refreshData();
    }

    private void refreshData() {
        GenericType<List<Menu>> gType = new GenericType<List<Menu>>() {
        };
        Menus = service.getAll(gType);
        
        if (! Menus.isEmpty()){
            model = new DefaultMenuModel();
            
            String _ItemURL ="";
            DefaultSubMenu firstSubmenu = new DefaultSubMenu("Menu");

          for (Menu _Menuitem : Menus) {
              _ItemURL ="/faces/";
             DefaultMenuItem item = new DefaultMenuItem(_Menuitem.getDisplayName());
             if (_Menuitem.isIsSecured()) {
                 _ItemURL = _ItemURL + "secured/";
             }
             item.setUrl( _ItemURL + _Menuitem.getPath());
             item.setIcon("ui-icon-" +_Menuitem.getIcon());
             firstSubmenu.addElement(item);
         }
               model.addElement(firstSubmenu);
        }
    }

    public void setService(MenuClient service) {
        this.service = service;
    }
}