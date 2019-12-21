package com.example.cms.api;

import com.example.cms.model.Customer;
import com.example.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return  customerService.addCutomer(customer);
    }
    @GetMapping
    public List<Customer> getCusomters(){
        return customerService.getCustomerList();
    }
    @GetMapping(value = "/{cusotmerId}")
    public Customer getCustomer(@PathVariable("cusotmerId") int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PutMapping(value = "/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
        return customerService.updateCustomer(customerId,customer);
    }
    @DeleteMapping(value = "/customerId")
    public void deleteCustomer(@PathVariable("cusotmerId") int customerId) {
        customerService.delteCustomer(customerId);
    }
}
