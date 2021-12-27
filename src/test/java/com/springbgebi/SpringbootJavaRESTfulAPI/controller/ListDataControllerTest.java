package com.springbgebi.SpringbootJavaRESTfulAPI.controller;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ListDataControllerTest {

    @Autowired
    ListDataController listDataController;

    @Test
    void testGetAllData() {
        List<ListData> listDataModelListInDb = listDataController.getAllData();
        assertThat(listDataModelListInDb).size().isGreaterThan(0);
    }

    //also covers for testGetDataById
    @Test
    void testCreateNewData() {
        String uid1 = UUID.randomUUID().toString();
        String uid2 = UUID.randomUUID().toString();
        String uid3 = UUID.randomUUID().toString() + "@test.com";
        long id = listDataController.getAllData().size();

        ListData listData = new ListData();
        listData.setFirstName(uid1);
        listData.setLastName(uid2);
        listData.setEmailId(uid3);
        listDataController.createNewData(listData);

        ResponseEntity<ListData> returnedData = listDataController.getDataById(id + 1);

        assertEquals(200, returnedData.getStatusCode().value());
        assertEquals(returnedData.getBody().getFirstName(), uid1);
        assertEquals(returnedData.getBody().getLastName(), uid2);
        assertEquals(returnedData.getBody().getEmailId(), uid3);
    }

    //update by id:
    @Test
    void testUpdateDataById() {
        //check database has minimum 1 entry: for testing purpose
        long id = listDataController.getAllData().size();
        assertTrue(id >= 1);

        //get old value
        ResponseEntity<ListData> oldDataValues = listDataController.getDataById(id);
        String oldFname = oldDataValues.getBody().getFirstName();
        String oldLname = oldDataValues.getBody().getLastName();
        String oldEmail = oldDataValues.getBody().getEmailId();

        //perform update
        oldDataValues.getBody().setFirstName(UUID.randomUUID().toString());
        oldDataValues.getBody().setLastName(UUID.randomUUID().toString());
        oldDataValues.getBody().setEmailId(UUID.randomUUID().toString() + "@test.com");

        listDataController.updateDataById(id, oldDataValues.getBody());

//        confirm updated
        ResponseEntity<ListData> newDataValues = listDataController.getDataById(id);
        assertEquals(200, newDataValues.getStatusCode().value());


        String newFname = newDataValues.getBody().getFirstName();
        String newLname = newDataValues.getBody().getLastName();
        String newEmail = newDataValues.getBody().getEmailId();

        assertTrue(!oldFname.equals(newFname) && !oldLname.equals(newLname) && !oldEmail.equals(newEmail));
    }
}