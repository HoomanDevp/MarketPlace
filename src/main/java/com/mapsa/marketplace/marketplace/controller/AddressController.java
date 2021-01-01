package com.mapsa.marketplace.marketplace.controller;

import com.mapsa.marketplace.marketplace.model.Address;
import com.mapsa.marketplace.marketplace.model.Product;
import com.mapsa.marketplace.marketplace.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    private AddressRepository addressRepository;

    @Autowired
    public void AddressRepository(AddressRepository addressRepository){
        this.addressRepository = addressRepository;    }

    @GetMapping
    public List<Address> getList(Pageable pageable){
        if (pageable == null)
            return addressRepository.findAll();
        else
            return addressRepository.findAll(pageable).toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody Address address){
        addressRepository.save(address);
        return "201(Created)";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public  String delete(@PathVariable long id){
        addressRepository.deleteById(id);
        return "202(Accepted)";
    }
    @PatchMapping("/{id}")

    public ResponseEntity<Address> updateAddress(@PathVariable long id){
        try{
            Address address = addressRepository.findById(id).orElseThrow(NullPointerException::new);
            addressRepository.save(address);
            return ResponseEntity.ok(address);
        }
        catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
