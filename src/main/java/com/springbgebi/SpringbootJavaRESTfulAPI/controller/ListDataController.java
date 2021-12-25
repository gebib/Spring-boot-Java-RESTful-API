package com.springbgebi.SpringbootJavaRESTfulAPI.controller;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListDataModel;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.ListDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //test
    public String testMethod(String helloString) {
        return helloString + " World";
    }
}
