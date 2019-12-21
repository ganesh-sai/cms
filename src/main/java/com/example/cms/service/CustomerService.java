package com.example.cms.service;

import com.example.cms.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerService {
    private int customerIdCount = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    public Customer addCutomer(Customer customer) {
        customer.setCustomerId(customerIdCount);
        customerList.add(customer);
        customerIdCount++;
        return  customer;
    }

    public List<Customer> getCustomerList(){
        return customerList;
    }

    public Customer getCustomer(int customerId) {
        return  customerList
                .stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .findFirst()
                .get();
    }

    public Customer updateCustomer(int customerId, Customer customer) {
        customerList
                .stream()
                .forEach(c -> {
                    if (c.getCustomerId() == customerId) {
                        c.setCustomerFirstName(customer.getCustomerFirstName());
                        c.setCustomerLastName(customer.getCustomerLastName());
                        c.setCustomerEmail(customer.getCustomerEmail());
                    }
                });
        return  customerList
                .stream()
                .filter(c -> c.getCustomerId() == customerId).findFirst().get();
    }

    public void delteCustomer(int cusomterId) {
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerId() == cusomterId) {
                            customerList.remove(c);
                    }
                });
    }
}
