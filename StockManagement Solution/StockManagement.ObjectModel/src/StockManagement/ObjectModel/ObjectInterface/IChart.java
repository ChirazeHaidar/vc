/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.ObjectModel.ObjectInterface;

import StockManagement.ObjectModel.ValueObject.*;
import java.util.List;

/**
 *
 * @author MikeRmaily
 */
public interface IChart {

    /**
     *
     * @return
     */
    public List<Chart> GetProductsOrders();
}
