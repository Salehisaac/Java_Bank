package com.example.bankapproject.Bank_AP_Project.src;

import com.example.bankapproject.Bank_AP_Project.SEApp.EndApp;
import com.example.bankapproject.Bank_AP_Project.SEApp.StartApp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class CustomerClient
{
    public static void main(String[] args) {
        System.out.println("----------------------- WELCOME -----------------------");
        START();
        Scanner input = new Scanner(System.in);
        main_menu: while (true)
        {
            main_menu();
            String choose = input.nextLine();
            if (choose.equals("1")) // sign up
            {
                System.out.println("Name:");
                String name = input.nextLine();
                System.out.println("N.I.D. :");
                String nid = input.nextLine();
                System.out.println("Password:");
                String pass = input.nextLine();
                System.out.println("How much money do you have?");
                int initial_money = input.nextInt();
                Auth.customer_sign_up(name, nid, pass, initial_money);
            }
            else if (choose.equals("2")) // sign in
            {
                System.out.println("N.I.D. :");
                String nid = input.nextLine();
                System.out.println("Password:");
                String pass = input.nextLine();
                Customer cus = Auth.customer_login(nid, pass);
                System.out.println("Name: " + cus.getName() + "\n" + "National ID: " + cus.getNational_id() + "\n" + "Money: " + cus.getInitial_money());
                customer_menu: while (true)
                {
                    customer_menu();
                    String next_choose = input.nextLine();
                    if (next_choose.equals("1")) // show all accounts
                    {
                        System.out.println(cus.getAll_accounts());
                    }
                    else if (next_choose.equals("2")) // show balance
                    {
                        System.out.println("Account ID:");
                        System.out.println("Balance: " + cus.get_account_by_id(input.nextLine()).getMoney());
                    }
                    else if (next_choose.equals("3")) // charge account
                    {
                        System.out.println("Account ID:");
                        String acc_id = input.nextLine();
                        System.out.println("َAmount:");
                        int amount = input.nextInt();
                        if(cus.get_account_by_id(acc_id) != null)
                        {
                            cus.get_account_by_id(acc_id).charge_account(amount);
                        }
                        else
                        {
                            System.out.println("Account not found !");
                        }
                    }
                    else if(next_choose.equals("4"))
                    {
                        System.out.println("Enter origin account ID:");
                        String or_id = input.nextLine();
                        System.out.println("Enter destination account ID:");
                        String des_id = input.nextLine();
                        Account from = cus.get_account_by_id(or_id);
                        Account to = Account.get_account_by_id(des_id);
                        if (from != null && to != null) {
                            System.out.println("How much money do you want to withdraw:");
                            int amount = input.nextInt();
                            new Transaction(amount, from, to, LocalDateTime.now()).withdraw();
                        }
                        else
                        {
                            System.out.println("Destination or origin account ID incorrect");
                        }
                    }
                    else if (next_choose.equals("0")) // exit
                    {
                        break customer_menu;
                    }
                }
            }
            else if (choose.equals("0"))
            {
                break main_menu;
            }
        }
        try
        {
            END();
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
        }
    }
    private static void START()
    {
        StartApp.read_admin_data();
        StartApp.read_employee_data();
        StartApp.read_customer_data();
        StartApp.read_account_data();
    }
    private static void END() throws IOException
    {
        EndApp.save_admin_data(Admin.getAll_admins());
        EndApp.save_employee_data(Employee.getAll_employees());
        EndApp.save_customer_data(Customer.getAll_customers());
        EndApp.save_account_data(Account.getAll_accounts());
    }
    private static void main_menu()
    {
        String menu = """
                [1] Sign up
                [2] Sign in
                [0] Exit
                """;
        System.out.println(menu);
    }
    private static void customer_menu()
    {
        String menu = """
                [1] Show all accounts
                [2] Show balance
                [3] Charge account
                [4] Withdraw
                [5] Show loan balance
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }

}
