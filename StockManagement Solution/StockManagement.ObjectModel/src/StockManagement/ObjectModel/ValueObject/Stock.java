package StockManagement.ObjectModel.ValueObject;
// Generated Aug 10, 2017 10:15:42 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Stock generated by hbm2java
 */
public class Stock  implements java.io.Serializable {


     private Integer stkCode;
     private Company company;
     private String stkName;
     private String stkTel;
     private String stkAddress;
     private Set stockProducts = new HashSet(0);

    public Stock() {
    }

	
    public Stock(Company company) {
        this.company = company;
    }
    public Stock(Company company, String stkName, String stkTel, String stkAddress, Set stockProducts) {
       this.company = company;
       this.stkName = stkName;
       this.stkTel = stkTel;
       this.stkAddress = stkAddress;
       this.stockProducts = stockProducts;
    }
   
    public Integer getStkCode() {
        return this.stkCode;
    }
    
    public void setStkCode(Integer stkCode) {
        this.stkCode = stkCode;
    }
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    public String getStkName() {
        return this.stkName;
    }
    
    public void setStkName(String stkName) {
        this.stkName = stkName;
    }
    public String getStkTel() {
        return this.stkTel;
    }
    
    public void setStkTel(String stkTel) {
        this.stkTel = stkTel;
    }
    public String getStkAddress() {
        return this.stkAddress;
    }
    
    public void setStkAddress(String stkAddress) {
        this.stkAddress = stkAddress;
    }
    public Set getStockProducts() {
        return this.stockProducts;
    }
    
    public void setStockProducts(Set stockProducts) {
        this.stockProducts = stockProducts;
    }




}


