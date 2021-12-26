package com.springbgebi.SpringbootJavaRESTfulAPI.controller;

import com.springbgebi.SpringbootJavaRESTfulAPI.exception.ResourceNotFoundException;
import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListData;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.ListDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")//enable any front end to call this API
@CrossOrigin(origins = {"http://localhost:3000/", "http://localhost:4000/", "andMore"})
//handle REST requests
@RestController
@RequestMapping("/api/v1/data")
public class ListDataController {

    private ListDataRepository listDataRepository;

    public ListDataController() {
    }

    @Autowired
    public ListDataController(ListDataRepository listDataRepository) {
        this.listDataRepository = listDataRepository;
    }

    //test
    public String testMethod(String helloString) {
        return helloString + " World";
    }

    @GetMapping
    public List<ListData> getAllData() {
        return listDataRepository.findAll();
    }

    @PostMapping
    public ListData createNewData(@RequestBody ListData listData) {
        return listDataRepository.save(listData);
    }

    @GetMapping("{id}")
    public ResponseEntity<ListData> getDataById(@PathVariable long id) {
        ListData listData = listDataRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Data with id: " + id + ""));
        return ResponseEntity.ok(listData);
    }
}
