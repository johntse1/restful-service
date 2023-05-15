package au.com.johntse.restfulservice.controller;

import au.com.johntse.restfulservice.controller.model.ProductID;
import au.com.johntse.restfulservice.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Handles HTTP calls
@RestController
public class ProductController {
    //POST
    @PostMapping("/product/")
    //Request Body binds parameters into the object
    public ResponseEntity<ProductID> createProduct(@RequestBody Product product){
        //Generates random Product ID for each item and returns a successful call
        ProductID result = new ProductID(UUID.randomUUID().toString());
        System.out.println(product);
        return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(result);
    }
    //GET
    @GetMapping("/product")
    //generates json to client for the products
    //returns only 3 products because it is not stored anywhere at the moment
    public List<Product> getAllProducts(){
        List<Product> result = new ArrayList<>();
        result.add(new Product("1","Product 1",new BigDecimal(542.55)));
        result.add(new Product("2","Product 2",new BigDecimal(542.45)));
        result.add(new Product("3","Product 3",new BigDecimal(542.35)));

        return result;
    }

    //returns specific product ID
    @GetMapping("/product/{id}")
    //pathvariable binds the input string to the id mapping
    public Product getProductById(@PathVariable final String id){
        return new Product("232","Single test Product",new BigDecimal(45.32));
    }

    @PatchMapping("/product")
    public String patchProduct(@RequestBody final Product product){
        System.out.println(product);
        return "Patched";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@RequestBody final String id){
        System.out.println(id);
        return "deleted";
    }
}
