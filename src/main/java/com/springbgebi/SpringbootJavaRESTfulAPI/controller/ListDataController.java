package com.springbgebi.SpringbootJavaRESTfulAPI.controller;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListDataModel;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.ListDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public List<ListDataModel> getAllData() {
        return listDataRepository.findAll();
    }

    @PostMapping
    public ListDataModel createListData(@RequestBody ListDataModel listDataModel) {
        return listDataRepository.save(listDataModel);
    }

    //test
    public String testMethod(String helloString) {
        return helloString + " World";
    }
}
