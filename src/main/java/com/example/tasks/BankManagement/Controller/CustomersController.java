package com.example.tasks.BankManagement.Controller;

import com.example.tasks.BankManagement.Model.Customers;
import com.example.tasks.TrackerSystem.Api.ApiResopnse;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/bank-management")
public class CustomersController {

    //Get all the customers  .. done
    //add new customers  .. done
    //update custtomers  .. done
    //delete customer via index  .. done
    //delete all customers .. done
    //Deposit money to customer .. done
    //Withdraw money from customers .. done
    ArrayList<Customers> customers = new ArrayList<>();

    // get all customers  .. done
    @GetMapping("/get")
    public ArrayList<Customers> getCustomers(){
        return customers;
    }

    //add new customers .. done
    @PostMapping("add")
    public ApiResopnse addCustomer(@RequestBody Customers customer){
        customers.add(customer);
        return new ApiResopnse("Customer Added Successfully");
    }

    //update customers .. done
    @PutMapping("/update/{index}")
    public ApiResopnse updateCustomer(@PathVariable int index, @RequestBody Customers customer){
        customers.set(index, customer);
        return new ApiResopnse("Customer Updated Successfully");
    }

    //delete customer via index .. done
    @DeleteMapping("/delete/{index}")
    public ApiResopnse delete(@PathVariable int index){
        customers.remove(index);
        return new ApiResopnse("Customer Deleted Successfully");
    }

    //delete all .. done
    @DeleteMapping("/delete/all")
    public ApiResopnse deleteAll(){
        customers.clear();
        return new ApiResopnse("All Customers Deleted Successfully!");
    }


    //Deposit money to customer .. done
    @PostMapping("/deposit/{index}/{amount}")
    public ApiResopnse depositMoney(@PathVariable int index, @PathVariable float amount){
        Customers customer = customers.get(index);
        customer.balance += amount;
        return new ApiResopnse("Money Deposited Successfully");
    }

    //Withdraw money from customers .. done
    @PostMapping("/withdraw/{index}/{amount}")
    public ApiResopnse withdrawMoney(@PathVariable int index, @PathVariable float amount) {
        Customers customer = customers.get(index);
        if (customer.balance >= amount) {
            customer.balance -= amount;
            return new ApiResopnse("Money Withdrawn Successfully");
        } else {
            return new ApiResopnse("Insufficient Balance");
        }

    }
}
