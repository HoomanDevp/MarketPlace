package com.mapsa.marketplace.marketplace.controller;

import com.mapsa.marketplace.marketplace.model.Product;
import com.mapsa.marketplace.marketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "product")
public class ProductController {

   private ProductRepository productRepository;

   @Autowired
   public void productRepository(ProductRepository productRepository){
       this.productRepository = productRepository;    }

    @GetMapping
    public List<Product> getList(Pageable pageable){
        if (pageable == null)
           return productRepository.findAll();
       else
           return productRepository.findAll(pageable).toList();
   }
    //@AccessControl(value = "admin")
   @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody Product product){
       productRepository.save(product);
        return "201(Created)";
   }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
   public  String delete(@PathVariable long id){
       productRepository.deleteById(id);
        return "202(Accepted)";
    }
    @PatchMapping("/{id}")

    public ResponseEntity<Product> updateProduct(@PathVariable String id){
       try{
           Product product = productRepository.findById(id).orElseThrow(NullPointerException::new);
           productRepository.save(product);
           return ResponseEntity.ok(product);
       }
       catch (NullPointerException e){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
    }

   }

