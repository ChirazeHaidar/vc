/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ObjectInterface;

import StockManagement.ObjectModel.ValueObject.Invoice;
import java.util.List;

/**
 *
 * @author ali chreif
 */
public interface IInvoice {

    int add(Invoice invoice);

    boolean delete(Invoice invoice);

    boolean delete(int invCode);

    Invoice get(int invCode);

    List<Invoice> getAll();

    boolean update(Invoice invoice);
    
}
