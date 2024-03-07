package com.example.tasks.BankManagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customers {
    private String ID;
    private String username;
    public float balance;
}
