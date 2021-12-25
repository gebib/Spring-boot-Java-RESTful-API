package com.springbgebi.SpringbootJavaRESTfulAPI;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.ListDataModel;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.ListDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJavaResTfulApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJavaResTfulApiApplication.class, args);
    }


    @Autowired
    private ListDataRepository listDataRepository;

    @Override
    public void run(String... args) throws Exception {
        /*
        ListDataModel listDataModel = new ListDataModel();
        listDataModel.setFirstName("Gebi");
        listDataModel.setLastName("Beshir");
        listDataModel.setEmailId("gebi@gmgm.com");
        listDataRepository.save(listDataModel);

        ListDataModel listDataModel1 = new ListDataModel();
        listDataModel1.setFirstName("Kalid");
        listDataModel1.setLastName("Beshir");
        listDataModel1.setEmailId("kald@gmgm.com");
        listDataRepository.save(listDataModel1);
         */
    }
}
