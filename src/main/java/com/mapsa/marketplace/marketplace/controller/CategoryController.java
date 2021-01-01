package com.mapsa.marketplace.marketplace.controller;

import com.mapsa.marketplace.marketplace.model.Category;
import com.mapsa.marketplace.marketplace.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("category")
    public class CategoryController {

        private CategoryRepository categoryRepository;

        @Autowired
        public void CategoryRepository(CategoryRepository categoryRepository){
            this.categoryRepository = categoryRepository;    }

        @GetMapping
        public List<Category> getList(Pageable pageable){
            if (pageable == null)
                return categoryRepository.findAll();
            else
                return categoryRepository.findAll(pageable).toList();
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public String save(@RequestBody Category category){
            categoryRepository.save(category);
            return "201(Created)";
        }


        @DeleteMapping("/{id}")
        @ResponseStatus(HttpStatus.ACCEPTED)
        public  String delete(@PathVariable String id){
            categoryRepository.deleteById(id);
            return "202(Accepted)";
        }
        @PatchMapping("/{id}")

        public ResponseEntity<Category> updateCategory(@PathVariable long id){
            try{
                Category category = categoryRepository.findById(String.valueOf(id)).orElseThrow(NullPointerException::new);
                categoryRepository.save(category);
                return ResponseEntity.ok(category);
            }
            catch (NullPointerException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }

    }
