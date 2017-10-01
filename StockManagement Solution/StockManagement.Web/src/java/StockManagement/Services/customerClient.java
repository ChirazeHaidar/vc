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
 * Jersey REST client generated for REST resource:ClientResource [Client]<br>
 * USAGE:
 * <pre>
 *        customerClient client = new customerClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Chiraze Haidar
 */
@ManagedBean(name="customerClient")
@ApplicationScoped
public class customerClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = Configuration.ServiceURL;//"http://localhost:8080/StockManagement.Services/webresources";

    public customerClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Client");
    }

    public <T> T add(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("add").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getAll(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T get(Class<T> responseType, String cltCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("code/{0}", new Object[]{cltCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T update(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("update").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T addOrder(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("attachOrder").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T sendMessage(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("sendMessageById").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T sendCatalog(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("sendCatalogById").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T delete(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("delete").request(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.TEXT_PLAIN), responseType);
    }

    public <T> T getOrders(Class<T> responseType, String cltCode) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("orders/{0}", new Object[]{cltCode}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
