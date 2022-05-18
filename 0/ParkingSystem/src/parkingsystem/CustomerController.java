package parkingsystem;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.sql.DriverManager;

public class CustomerController {
    
    public static void entry(ResultSet Resultset_for_customer, Customers[] ticket,int user_input, String plateNumber, int phoneNumber){
            try{
                Scanner input = new Scanner(System.in);
                if(ticket[user_input-1].isSpotAvailable() == false){//check if this spot is available
                    ticket[user_input-1].setPlate_Number_of_car(plateNumber);
                    ticket[user_input-1].setPhone_of_ticketOwner(phoneNumber);
                    ticket[user_input-1].setMillisecond_when_enter(System.currentTimeMillis());
                    Resultset_for_customer.last();
                    ticket[user_input - 1] = new Customers(Resultset_for_customer.getInt(1)+1, ticket[user_input-1].getPlate_Number_of_car(), user_input, ticket[user_input-1].getPhone_of_ticketOwner(), new Date(ticket[user_input-1].getMillisecond_when_enter()));
                    
                    customerMethods_inDatabase.addCustomerInDatebase(Resultset_for_customer, ticket[user_input-1]);
                }
                else{
                    System.out.println("This spot is not available\n");
                }
            }
            catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        
    static String pay_theBill(ResultSet Resultset_for_customer, Customers[] ticket, int customer_spot){
        if(ticket[customer_spot-1].isSpotAvailable()==true){
            ticket[customer_spot-1].doSpotAvailable();
            return customerMethods_inDatabase.customer_exit_fromDatabase(Resultset_for_customer, customer_spot);
        }                
        else{
            return "this spot is empty";
        }
    }
    
}
