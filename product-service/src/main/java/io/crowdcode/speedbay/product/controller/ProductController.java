package io.crowdcode.speedbay.product.controller;

import io.crowdcode.speedbay.product.model.Product;
import io.crowdcode.speedbay.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(
            path="/products",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void post(@RequestBody Product product) {
        productRepository.save(product);
    }

    @RequestMapping(
            path="/products/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public List<Product> get(@PathVariable("name") String name) {
        return productRepository.findByName(name);
    }

}
