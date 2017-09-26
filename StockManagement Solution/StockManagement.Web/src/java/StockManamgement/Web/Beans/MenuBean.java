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


/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "MenuBean")
@ViewScoped
public class MenuBean implements Serializable {
    private List<Menu> Menus;

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
    }

    public void setService(MenuClient service) {
        this.service = service;
    }

  
       
}