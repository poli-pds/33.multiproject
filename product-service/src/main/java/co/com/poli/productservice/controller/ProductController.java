package co.com.poli.productservice.controller;

import co.com.poli.productservice.helpers.Response;
import co.com.poli.productservice.helpers.ResponseBuild;
import co.com.poli.productservice.persistence.entity.Category;
import co.com.poli.productservice.persistence.entity.Product;
import co.com.poli.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ResponseBuild build;

    @PostMapping
    public Response save(@Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return build.failed(result.getAllErrors());
        }
        productService.save(product);
        return build.success(product);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id) {
        Product product = productService.findById(id);
        productService.delete(product);
        return build.success(product);
    }

    @GetMapping
    public Response findAll() {
        return build.success(productService.findAll());
    }

    @GetMapping("/category")
    public Response findByCategory(@RequestBody Category category) {
        return build.success(productService.findByCategory(category));
    }

    @GetMapping("/{id}")
    public Response findById(@PathVariable("id") Long id) {
        return build.success(productService.findById(id));
    }

}