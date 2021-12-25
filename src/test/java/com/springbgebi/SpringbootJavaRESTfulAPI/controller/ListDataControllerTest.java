package com.springbgebi.SpringbootJavaRESTfulAPI.controller;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListDataModel;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.ListDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListDataControllerTest {

    @Autowired
    private ListDataRepository listDataRepository;

    @Test
    void testGetAllData() {
        List<ListDataModel> listDataModelListInDb = listDataRepository.findAll();
        assertThat(listDataModelListInDb).size().isGreaterThan(0);
    }

    @Test
    void testMethod() {
        ListDataController listDataController = new ListDataController(); //arrange
        String response = listDataController.testMethod("Hello"); //act
        assertEquals("Hello World", response);//assert
    }
}