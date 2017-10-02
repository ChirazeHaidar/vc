/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManamgement.Web.Beans;

import StockManagement.ObjectModel.ValueObject.Branch;
import StockManagement.ObjectModel.ValueObject.Company;
import StockManagement.ObjectModel.ValueObject.Order;
import StockManagement.ObjectModel.ValueObject.User;
import StockManagement.Services.branchClient;
import StockManagement.Services.companyClient;
import StockManagement.Services.orderClient;
import StockManagement.Services.userClient;
import StockManamgement.Web.Utilities.MessageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import org.primefaces.model.DualListModel;

/**
 *
 * @author ali chreif
 */
@ManagedBean(name = "ordersBean")
@ViewScoped
public class OrdersBean implements Serializable {

    private int orderCode;
    private Date orderDate;
    private int orderSrc;
    private int orderDest;
    private int orderTrCode;
    private int orderQty;
    private int orderPrCode;
    private int orderCompCode;
    private int orderUsrCode;
    private int orderDbCr;
    private String branch;

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }
    private List<Branch> lb;
    private Map<String,String> branches;

    public void setBranches(Map<String, String> branches) {
        this.branches = branches;
    }

    public Map<String, String> getBranches() {
        return branches;
    }

   

   

    public void setLb(List<Branch> lb) {
        this.lb = lb;
    }

    public List<Branch> getLb() {
        return lb;
    }

    public void setCompanyBranches(Map<String, Object> companyBranches) {
        companyBranches = companyBranches;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setOrderSrc(int orderSrc) {
        this.orderSrc = orderSrc;
    }

    public void setOrderDest(int orderDest) {
        this.orderDest = orderDest;
    }

    public void setOrderTrCode(int orderTrCode) {
        this.orderTrCode = orderTrCode;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public void setOrderPrCode(int orderPrCode) {
        this.orderPrCode = orderPrCode;
    }

    public void setOrderCompCode(int orderCompCode) {
        this.orderCompCode = orderCompCode;
    }

    public void setOrderUsrCode(int orderUsrCode) {
        this.orderUsrCode = orderUsrCode;
    }

    public void setOrderDbCr(int orderDbCr) {
        this.orderDbCr = orderDbCr;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setCities(DualListModel<String> cities) {
        this.cities = cities;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public int getOrderSrc() {
        return orderSrc;
    }

    public int getOrderDest() {
        return orderDest;
    }

    public int getOrderTrCode() {
        return orderTrCode;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public int getOrderPrCode() {
        return orderPrCode;
    }

    public int getOrderCompCode() {
        return orderCompCode;
    }

    public int getOrderUsrCode() {
        return orderUsrCode;
    }

    public int getOrderDbCr() {
        return orderDbCr;
    }
    private Order selectedOrder;
    private List<Order> orders;

    @ManagedProperty("#{orderClient}")
    private transient orderClient service;

    public void setSelectedOrder(Order selectedOrder) {
        this.selectedOrder = selectedOrder;
    }

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    // <editor-fold defaultstate="collapsed" desc="Company method">
    @PostConstruct
    public void init() {
        //service = new companyClient();
        //add();
        refreshData();
        // selectedCompany = companies.get(0);
    }

    private void refreshData() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                getExternalContext().getRequestParameterMap();
        GenericType<List<Order>> gType = new GenericType<List<Order>>() {
        };
        
        GenericType<List<Branch>> gType2 = new GenericType<List<Branch>>() {
        };
        
        String compCode = params.get("compId");
        if ( compCode == null || compCode.isEmpty())
            compCode = "1";
        orders = service.getByCompany(gType, compCode);
        
        branchClient bc = new branchClient();
        lb = bc.getByCompany(gType2, compCode);
        
        branches  = new HashMap<String, String>();
        for(int i=0; i<lb.size(); i++){
            branches.put(lb.get(i).getBrCode().toString(), lb.get(i).getBrName());
        }
       
    }

    public void setService(orderClient service) {
        this.service = service;
    }

    public void add() {
        Order o = new Order();
        Company c = new Company();

        userClient client = new userClient();
        User u = client.get(User.class, "1");

        companyClient company = new companyClient();
        c = company.get(Company.class, "1");

        o.setCompany(c);
        o.setOrdDate(new Date());
        o.setOrdDestination(getOrderDest());
        o.setOrdQty(getOrderQty());
        o.setOrdSource(getOrderSrc());
        o.setPrCode(getOrderPrCode());
        o.setUser(u);
        o.setOrdDbCr(getOrderDbCr());

        service.add(o, int.class);
        
        refreshData();
        MessageView.Info("Info", "order saved successfully.");

        /*newC.setOrdCode(getCompName());
        newC.setCompDesc(getCompDesc());
        newC.setCompStatus(1);
        service.add(newC, String.class);
        refreshData();
        MessageView.Info("Info", "Company saved successfully.");*/
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }

    public void update() {
        service.update(selectedOrder, String.class);
        refreshData();
        MessageView.Info("Info", "Company updated successfully.");
    }

    public void delete() {
        service.delete(selectedOrder.getOrdCode(), boolean.class);
        refreshData();
        MessageView.Info("Info", "Order " + selectedOrder.getOrdCode() + " deleted successfully.");
    }

    /**
     * @return the companies
     */
    public List<Order> getOrders() {
        return orders;
    }

    /*public void onRowSelect(SelectEvent event) {
        Integer compCode = ((Company) event.getObject()).getCompCode();
        GenericType<List<Branch>> gType = new GenericType<List<Branch>>() {
        };
        branches = service.getBranches(gType, compCode.toString());

        if (null == branches || branches.isEmpty()) {
            return;
        }
        branchClient client = new branchClient();
        GenericType<List<Role>> roleType = new GenericType<List<Role>>() {
        };
        customBranches = new ArrayList();
        List<Role> includedRoles;
        List<Role> excludedRoles;
        for (Branch br : branches) {
            includedRoles = client.getRoles(roleType, br.getBrCode().toString());
            excludedRoles = client.getExcludedRoles(roleType, br.getBrCode().toString());
            CustomBranchInfo info = new CustomBranchInfo(br, includedRoles, excludedRoles);
            customBranches.add(info);
        }

        //roles = new DualListModel<>(includedRoles, excludedRoles);
    }*/
 /* public void addBranch() {
        newBranch.setCompany(selectedCompany);
        service.addBranch(newBranch, String.class);
        MessageView.Info("Info", "Branch saved successfully.");
        //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Company saved succesfully.."));
    }*/

 /*public void updateBranch() {
        selectedBranch.setCompany(selectedCompany);
        service.updateBranch(selectedBranch, String.class);
        MessageView.Info("Info", "Branch updated successfully.");
    }*/
    private DualListModel<String> cities;

    public DualListModel<String> getCities() {
        List<String> source = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            source.add("C" + i);
        }
        List<String> target = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            target.add("T" + i);
        }
        cities = new DualListModel<>(source, target);
        return cities;
    }

    /*public void onTransfer(TransferEvent event) {
        Role selectedRole;
        branchClient client = new branchClient();
        
            for (Object item : event.getItems()) {
                selectedRole = (Role) item;
                RoleBranch rb = new RoleBranch();
                rb.setBranch(selectedBranch);
                rb.setRole(selectedRole);
                if (!event.isAdd())//s->t
                    client.assignRole(rb, String.class);
                else
                    client.removeRole(rb, String.class);
            }
        

    }*/
    //</editor-fold>
}
