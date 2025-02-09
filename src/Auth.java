package com.example.bankapproject.Bank_AP_Project.src;

import java.util.ArrayList;

public class Auth
{
    // login
    public static Customer customer_login(String id, String password) throws NullPointerException
    {
        ArrayList<Customer> customers = Customer.getAll_customers();
        for (Customer cus:customers)
        {
            if(cus.getNational_id().equals(id) && cus.getPassword().equals(password))
            {
                return cus;
            }
        }
        return null;
    }
    public static Employee employee_login(String id, String password)
    {
        ArrayList<Employee> employees = Employee.getAll_employees();
        for (Employee emp: employees)
        {
            if(emp.getNational_id().equals(id) && emp.getPassword().equals(password))
            {
                return emp;
            }
        }
        return null;
    }
    // sign up
    public static void customer_sign_up(String name,String id, String password, int initial_money)
    {
            Customer cus = new Customer(name,id,password,initial_money);
            System.out.println("Sign up successful!\nNow you can login with your N.I.D. and password\n" + cus);
    }
}
