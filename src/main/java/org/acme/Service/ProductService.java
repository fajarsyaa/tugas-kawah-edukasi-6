package org.acme.Service;

import org.acme.Model.Product;
import io.vertx.core.json.JsonObject;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductService {

    public List<Product> list(){
        return Product.listAll();
    }

    
    public Product get(String name){
        return Product.find("product_name=?1",name).firstResult();
    }

    @Transactional
    public Product insert(JsonObject body){
        Product product = new Product();
        product.productName = body.getString("product_name");
        product.merk   = body.getString("merk","no merk");
        product.description = body.getString("description","no description");
        product.category = body.getString("category","no category");
        product.price =  body.getInteger("price",0);
        product.quantity = body.getInteger("quantity",0);
        product.persistAndFlush();
        return product;
    }
    @Transactional
    public JsonObject update(String name, JsonObject body){
        String productName = body.getString("product_name");
        String merk   = body.getString("merk","no merk");
        String description = body.getString("description","no description");
        String category = body.getString("category","no category");
        Integer price = body.getInteger("price",0);
        Integer quantity = body.getInteger("quantity",0);
        Product.update("product_name=?1,merk=?2,description=?3,category=?4,price=?5,quantity=?6 where product_name=?7",productName,merk,description,category,price,quantity,name);
        return body;
    }

    @Transactional
    public String deleted(String name){
        Product.delete("product_name",name);
        return "Succees deleted";
    }
}
