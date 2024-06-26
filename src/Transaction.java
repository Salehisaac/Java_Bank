package com.example.bankapproject.Bank_AP_Project.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Transaction
{
    private int amount;
    private LocalDateTime date;
    private Account from;
    private Account to;
    private Customer from_c = from.getOwner();
    private Customer to_c = to.getOwner();
    private static ArrayList<Transaction> all_transactions = new ArrayList<>();

    public Transaction(int amount, Account from, Account to, LocalDateTime date) // LocalDateTime.now()
    {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.date = date;
        all_transactions.add(this);
    }
    public void withdraw()
    {
        if(this.amount < from.getMoney())
        {
            System.out.println("Your account balance is insufficient");
        }
        else
        {
            from.setMoney(from.getMoney() - this.amount);
            to.setMoney(to.getMoney() + this.amount);
        }
    }
    public static LocalDateTime str_to_date(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date_time = LocalDateTime.parse(date, formatter);
        return date_time;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }
}
