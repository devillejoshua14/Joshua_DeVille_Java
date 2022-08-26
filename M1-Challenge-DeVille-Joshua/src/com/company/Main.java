package com.company;

import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {


    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );
    public static boolean customerExist(List<Customer> customers, int id) {
        int count = 0;
        if (customers.size() > 0) {
            for (Customer customer : customers) {
                if (id == customer.getId()) {
                    count++;
                }
            }
        }
        if(count > 0){return true;} else{return false;}
    }

    //Iterate through a List<String[]> that contains multiple records for each
    // Customer, converting it into List<Customer> where there is only one copy of each customer.
    // (Integer.parseInt() converts a String to an integer.)
    public static void main(String[] args) {
//        //Update this
        List<Customer> customers = new ArrayList<>();
        List<Customer> postiveAccoutnts = new ArrayList<>();
        List<Customer> negativeAccounts = new ArrayList<>();

        int index = 0;

        for(int i = 0; i < customerData.size(); i++) {
            String[] customer_Data = customerData.get(i);
            if (!customerExist(customers, Integer.parseInt(customer_Data[0]))) {
                Customer customer = new Customer();
                customer.setId(Integer.parseInt(customer_Data[0]));
                customer.setName(customer_Data[1]);
                customers.add(customer);
            }
            AccountRecord accountRecord = new AccountRecord();
            accountRecord.setCharge(Integer.parseInt(customer_Data[2]));
            accountRecord.setChargeDate(customer_Data[3]);

            for (Customer cust1 : customers) {
                if (cust1.getId() == Integer.parseInt(customer_Data[0])) {
                    index = customers.indexOf(cust1);
                }
            }
            customers.get(index).getCharges().add(accountRecord);
        }

        for(Customer customer1: customers){
            if(customer1.getBalance() > 0){
                postiveAccoutnts.add(customer1);
            }
            else {
                negativeAccounts.add(customer1);
            }
        }
        System.out.println(customers);
    }



//        List<Customer> customerAccounts = new ArrayList<>();
//        for (String[] customerData : customerData) {
//            Customer customer = customerAccounts.stream()
//                    .filter(account -> account.getId() == Integer.parseInt(customerData[0]))
//                    .findAny()
//                    .orElse(null);
//            if (customer == null) {
//                customer = new Customer();
//                customer.setId(Integer.parseInt(customerData[0]));
//                customer.setName(customerData[1]);
//                customerAccounts.add(customer);
//            }
//
//            AccountRecord accountRecord = new AccountRecord();
//            accountRecord.setCharge(Integer.parseInt(customerData[2]));
//            accountRecord.setChargeDate(customerData[3]);
//            customer.getCharges().add(accountRecord);

//        System.out.println("Positive accounts:");
//        System.out.println("Negative accounts:");
}


