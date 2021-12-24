package com.springbgebi.SpringbootJavaRESTfulAPI;

import com.springbgebi.SpringbootJavaRESTfulAPI.model.Employee;
import com.springbgebi.SpringbootJavaRESTfulAPI.repository.EmployeeRepository;
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
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("Gebi");
        employee.setLastName("Beshir");
        employee.setEmailId("gebi@gmgm.com");
        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setFirstName("Kalid");
        employee1.setLastName("Beshir");
        employee1.setEmailId("kald@gmgm.com");
        employeeRepository.save(employee1);
    }
}
