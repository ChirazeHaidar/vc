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
@ManagedBean(name="brandClient")
@ApplicationScoped
public class brandClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = Configuration.ServiceURL;//"http://localhost:8080/StockManagement.Services/webresources";

    public brandClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Brand");
    }

    public <T> T add(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("add").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }
    
    public <T> T getAll(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T get(Class<T> responseType, String brCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("code/{0}", new Object[]{brCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T update(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("update").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }
    
    public <T> T delete(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("delete").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), responseType);
    }
    
      public <T> T deleteProduct(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("deleteProductById").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), responseType);
    }

      public <T> T addProduct(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("addProduct").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

      public <T> T updateProduct(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("updateProduct").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }
    
      
       public <T> T getProducts(GenericType<T> responseType, int BrdCode) throws ClientErrorException {
          DebugExceptionMapper x = new DebugExceptionMapper();
            try {
              WebTarget resource = webTarget;
              resource = resource.path(java.text.MessageFormat.format("products/{0}", new Object[]{BrdCode}));
              return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
           } catch (Exception ex){
                System.out.println("voila" + x.toResponse(ex));    
              }
           return null;
    }

    
    public void close() {
        client.close();
    }
    
}
