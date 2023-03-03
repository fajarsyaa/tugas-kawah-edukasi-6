package org.acme.Controller;

import org.acme.Model.Product;
import org.acme.Service.ProductService;
import io.vertx.core.json.JsonObject;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {
    @Inject
    ProductService productService;
    @GET
    public List<Product> listProduct(){
        return productService.list();
    }

    @GET
    @Path("{name}")
    public Product getProduct(@PathParam("name") String name){
        return productService.get(name);
    }

    @POST
    public Product addProductd(JsonObject body){
        return productService.insert(body);
    }

    @PUT
    @Path("{name}")
    public JsonObject updateProduct(@PathParam("name") String name, JsonObject body){
        return productService.update(name,body);
    }

    @DELETE
    @Path("{name}")
    public String  deleteProduct(@PathParam("name") String name){
        return productService.deleted(name);
    }
}
