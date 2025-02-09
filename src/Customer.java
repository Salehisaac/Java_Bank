package com.example.bankapproject.Bank_AP_Project.src;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private String national_id;
    private String password;
    private int initial_money;
    private ArrayList<Account> all_accounts = new ArrayList<>();
    private static ArrayList<Customer> all_customers = new ArrayList<>();

    public Customer(String name, String national_id, String password, int initial_money) {
        this.name = name;
        this.national_id = national_id;
        this.password = password;
        this.initial_money = initial_money;
        all_customers.add(this);
    }

    public Customer() {
    }

    public void setInitial_money(int initial_money) {
        this.initial_money = initial_money;
    }

    public static Customer get_customer_by_national_id(String national_id)
    {
        for (Customer cus: all_customers)
        {
            if(cus.getNational_id().equals(national_id))
            {
                return cus;
            }
        }
        return null;
    }

    public Account get_account_by_id(String id)
    {
        for (Account acc: all_accounts)
        {
            if(acc.getAccount_id().equals(id))
            {
                return acc;
            }
        }
        return null;
    }

    public String getNational_id() {
        return national_id;
    }
    public static Customer get_customer_by_name(String name)
    {
        for (Customer cus:all_customers)
        {
            if(cus.name.equals(name))
            {
                return cus;
            }
        }
        return null;
    }

    public ArrayList<Account> getAll_accounts()
    {
        return all_accounts;
    }

    public static ArrayList<Customer> getAll_customers() {
        return all_customers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", national_id='" + national_id + '\'' +
                ", password='" + password + '\'' +
                ", initial_money='" + initial_money + '\'' +
                '}';
    }
    public static void show_all_customers()
    {
        for (Customer cus: all_customers)
        {
            System.out.println(cus);
        }
    }
    public void show_all_accounts()
    {
        for (Account acc: all_accounts)
        {
            System.out.println(acc);
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getInitial_money() {
        return initial_money;
    }

    public void set_new_password(String password) {
        this.password = password;
    }
    public void create_a_account()
    {
       all_accounts.add(new Account());
    }
}
