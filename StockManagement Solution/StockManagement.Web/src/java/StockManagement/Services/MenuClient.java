/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StockManagement.Services;

import StockManamgement.Web.Utilities.Configuration;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

/**
 * Jersey REST client generated for REST resource:BranchResource [Branch]<br>
 * USAGE:
 * <pre>
 *        branchClient client = new branchClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author MikeRmaily
 */
@ManagedBean(name="MenuClient")
@ApplicationScoped
public class MenuClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI =Configuration.ServiceURL;// "http://localhost:8080/StockManagement.Services/webresources";

    public MenuClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Menu");
    }

 
    
    public <T> T getAll(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

 
    
    public void close() {
        client.close();
    }
    
}
