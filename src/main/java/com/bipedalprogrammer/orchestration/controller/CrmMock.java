package com.bipedalprogrammer.controller;

import com.bipedalprogrammer.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("/crm/api")
public class CrmMock {
    private HashMap<String, Customer> customers = new HashMap<>();

    public CrmMock() {
        customers.put("warnerbros", new Customer("c1234", "Acme Company", LocalDate.now()));
    }
    @GetMapping(path = "/customer/{customerId}", produces = "application/json")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        var customer = customers.get(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(customer);
        }
    }
}
