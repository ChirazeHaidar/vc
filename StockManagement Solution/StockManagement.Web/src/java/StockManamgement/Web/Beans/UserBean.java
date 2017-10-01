/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.User;
import StockManagement.Services.userClient;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.ws.rs.core.GenericType;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author MikeRmaily
 */
@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean implements Serializable {

    private String FullName;
    private String UserName;
    private String Password;
    private String Mobile;
    private String Address;    

    private List<User> Users;
    private User selectedUser;
      
    @ManagedProperty("#{userClient}")
     private transient userClient service;

    @PostConstruct
    public void init() {
          refreshData();
    }

    private void refreshData() {
        GenericType<List<User>> gType = new GenericType<List<User>>() {
        };
        Users = service.getAll(gType);
    }

    public void setService(userClient service) {
        this.service = service;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(List<User> Users) {
        this.Users = Users;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public userClient getService() {
        return service;
    }

    public void add() {
        User newUser = new User();
        newUser.setUsrAddress(getAddress());
        newUser.setUsrFullname(getFullName());
        newUser.setUsrMobile(getMobile());
        newUser.setUsrPassword(getPassword());
        newUser.setUsrUsername(getUserName());
        service.add(newUser, String.class);
        refreshData();
        MessageView.Info("Info", "User saved successfully.");
    }

    public void update() {
        service.update(selectedUser, String.class);
        refreshData();
        MessageView.Info("Info", "User updated successfully.");
    }
     
        public void delete() {
        service.delete(selectedUser.getUsrCode(), String.class);
        refreshData();
        MessageView.Info("Info", "User " + selectedUser.getUsrUsername()+ " deleted successfully.");
    }
        
       public boolean onRowSelect(SelectEvent event) {
//          Integer BrdCode = ((Brand) event.getObject()).getBrdCode();
//        GenericType<List<Product>> gType = new GenericType<List<Product>>() {};
//       products = service.getProducts(gType, BrdCode);
//     //   setProducts(products);
//          return  products !=null;
return false;
}
       
}