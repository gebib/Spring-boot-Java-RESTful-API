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

    //get all list of data
    @GetMapping
    public List<ListData> getAllData() {
        return listDataRepository.findAll();
    }

    //create new entry of data in db
    @PostMapping
    public ListData createNewData(@RequestBody ListData listData) {
        return listDataRepository.save(listData);
    }

    //get single entry identified by id
    @GetMapping("{id}")
    public ResponseEntity<ListData> getDataById(@PathVariable long id) {
        ListData listData = listDataRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Data with id: " + id + " not found"));
        return ResponseEntity.ok(listData);
    }

    //@Request body => convert from JSON to JavaOBJect.
    @PutMapping("{id}")
    public ResponseEntity<ListData> updateDataById(@PathVariable long id, @RequestBody ListData updatedListData) {
        ListData oldListData = listDataRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Data with id: " + id + " not found for updating."));
        oldListData.setFirstName(updatedListData.getFirstName());
        oldListData.setLastName(updatedListData.getLastName());
        oldListData.setEmailId(updatedListData.getEmailId());

        listDataRepository.save(updatedListData);
        return ResponseEntity.ok(oldListData);
    }
}
