package au.com.johntse.restfulservice.controller;

import au.com.johntse.restfulservice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Handles HTTP calls
@RestController
public class ProductController {
    @PostMapping("/product")
    //Request Body binds parameters into the object
    public String createProduct(@RequestBody Product product){
        System.out.println(product);
        return "123456";
    }
}
