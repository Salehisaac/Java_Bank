package com.example.bankapproject.Bank_AP_Project.src;

import java.util.ArrayList;

public class Employee
{
    private String name;
    private String national_id;
    private String password;
    private int salary;

    private static ArrayList<Employee> all_employees = new ArrayList<>();

    public Employee(String name, String national_id, String password, int salary)
    {
        this.name = name;
        this.national_id = national_id;
        this.password = password;
        all_employees.add(this);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", national_id='" + national_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static ArrayList<Employee> getAll_employees()
    {
        return all_employees;
    }
    public static void show_all_employees()
    {
        for (Employee emp: all_employees)
        {
            System.out.println(emp);
        }
    }
    public static Employee get_employee_by_national_id(String national_id)
    {
        for (Employee emp: all_employees)
        {
            if(emp.national_id.equals(national_id))
            {
                return emp;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public String getNational_id() {
        return national_id;
    }

    public String getPassword() {
        return password;
    }

    public int getSalary() {
        return salary;
    }
    public void set_salary(int salary) {
        this.salary = salary;
    }

    public void set_new_password(String password) {
        this.password = password;
    }
}
