/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.MangeObject;

import StockManagement.ObjectModel.ObjectInterface.IInvoice;
import StockManagement.ObjectModel.Utilities.HibernateUtil;
import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * 
 * @author ali chreif
 */
public class InvoiceController implements IInvoice {

    private SessionFactory _sessionFactory;
    private Session _session;

    public InvoiceController() {
        _sessionFactory = HibernateUtil.getSessionFactory();
        _session = _sessionFactory.openSession();
    }
    @Override
    public Invoice get(int invCode) {
       Object objAction = _session.get(Invoice.class, invCode);
        if (null == objAction) {
            return null;
        }
        return (Invoice) objAction;
    }

    @Override
    public List<Invoice> getAll() {
       List<Invoice> invoices = _session.createQuery("From Invoice").list();
        if (null == invoices || invoices.isEmpty()) {
            return null;
        }
        return invoices;
    }

    

    @Override
    public int add(Invoice invoice) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.save(invoice);
            tx.commit();
            return invoice.getInvCode();
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean update(Invoice invoice) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.update(invoice);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(Invoice invoice) {
         try {
            Transaction tx = _session.beginTransaction();
            _session.delete(invoice);
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public boolean delete(int invCode) {
        try {
            Transaction tx = _session.beginTransaction();
            _session.createQuery("delete from Invoice where invCode= " + invCode).executeUpdate();
            tx.commit();
            return true;
        } catch (Exception e) {
            throw (e);
        }
    }
    
}
