package StockManagement.ObjectModel.ValueObject;
// Generated Aug 10, 2017 10:15:42 AM by Hibernate Tools 4.3.1



/**
 * UserRole generated by hbm2java
 */
public class UserRole  implements java.io.Serializable {


     private Integer usrRoleCode;
     private Role role;
     private User user;

    public UserRole() {
    }

    public UserRole(Role role, User user) {
       this.role = role;
       this.user = user;
    }
   
    public Integer getUsrRoleCode() {
        return this.usrRoleCode;
    }
    
    public void setUsrRoleCode(Integer usrRoleCode) {
        this.usrRoleCode = usrRoleCode;
    }
    public Role getRole() {
        return this.role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }




}


