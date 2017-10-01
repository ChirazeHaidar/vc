package StockManagement.ObjectModel.ValueObject;
// Generated Aug 10, 2017 10:15:42 AM by Hibernate Tools 4.3.1


import StockManagement.ObjectModel.Utilities.Endpoint;
import java.util.Date;

/**
 * Order generated by hbm2java
 */
public class Order  implements java.io.Serializable {


     private Integer ordCode;
     private TransactionType transactionType;
     private User user;
     private Company company;
     private Date ordDate;
     private int ordSource;
     private int ordDestination;
     private int ordQty;
     private int prCode;
     private Endpoint source;
     private Endpoint destination;
     private int ordDbCr;

    public void setOrdDbCr(int ordDbCr) {
        this.ordDbCr = ordDbCr;
    }

    public int getOrdDbCr() {
        return ordDbCr;
    }
     
    public Order() {
    }

    public Order(TransactionType transactionType, User user, Company company, Date ordDate, int ordSource, int ordDestination, int ordQty, int prCode, int ordDbCr) {
       this.transactionType = transactionType;
       this.user = user;
       this.company = company;
       this.ordDate = ordDate;
       this.ordSource = ordSource;
       this.ordDestination = ordDestination;
       this.ordQty = ordQty;
       this.prCode = prCode;
       this.ordDbCr = ordDbCr;
    }
   
    public Integer getOrdCode() {
        return this.ordCode;
    }
    
    public void setOrdCode(Integer ordCode) {
        this.ordCode = ordCode;
    }
    public TransactionType getTransactionType() {
        return this.transactionType;
    }
    
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public Company getCompany() {
        return this.company;
    }
    
    public void setCompany(Company company) {
        this.company = company;
    }
    public Date getOrdDate() {
        return this.ordDate;
    }
    
    public void setOrdDate(Date ordDate) {
        this.ordDate = ordDate;
    }
    public int getOrdSource() {
        return this.ordSource;
    }
    
    public void setOrdSource(int ordSource) {
        this.ordSource = ordSource;
    }
    public int getOrdDestination() {
        return this.ordDestination;
    }
    
    public void setOrdDestination(int ordDestination) {
        this.ordDestination = ordDestination;
    }
    public int getOrdQty() {
        return this.ordQty;
    }
    
    public void setOrdQty(int ordQty) {
        this.ordQty = ordQty;
    }
    public int getPrCode() {
        return this.prCode;
    }
    
    public void setPrCode(int prCode) {
        this.prCode = prCode;
    }

    /**
     * @return the source
     */
    public Endpoint getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Endpoint source) {
        this.source = source;
    }

    /**
     * @return the destination
     */
    public Endpoint getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(Endpoint destination) {
        this.destination = destination;
    }




}


