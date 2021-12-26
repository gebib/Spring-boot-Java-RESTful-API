package com.springbgebi.SpringbootJavaRESTfulAPI.controller;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListData;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.ListDataRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListDataControllerTest {

    @Autowired
    private ListDataRepository listDataRepository;

    @Test
    void testMethod() {
        ListDataController listDataController = new ListDataController(); //arrange
        String response = listDataController.testMethod("Hello"); //act
        assertEquals("Hello World", response);//assert
    }

    @Test
    void testGetAllData() {
        List<ListData> listDataModelListInDb = listDataRepository.findAll();
        assertThat(listDataModelListInDb).size().isGreaterThan(0);
    }

    //also covers for testGetDataById
    @Test
    void testCreateNewData() {
        String uid1 = UUID.randomUUID().toString();
        String uid2 = UUID.randomUUID().toString();
        String uid3 = UUID.randomUUID().toString() + "@test.com";
        long id = listDataRepository.findAll().size();

        ListData listData = new ListData();
        listData.setFirstName(uid1);
        listData.setLastName(uid2);
        listData.setEmailId(uid3);
        listDataRepository.save(listData);

        ListData returnedData = listDataRepository.findById(id + 1).get();
        assertEquals(returnedData.getFirstName(), uid1);
        assertEquals(returnedData.getLastName(), uid2);
        assertEquals(returnedData.getEmailId(), uid3);
    }
}