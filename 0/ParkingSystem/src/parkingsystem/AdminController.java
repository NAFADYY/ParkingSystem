package parkingsystem;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.sql.DriverManager;

class AdminController{
        
    static boolean checkAccount(ResultSet Resultset_for_admin, Admins newAdmin){
        return adminAccount.LogIn(Resultset_for_admin, newAdmin);
    }
     
    static String parkedCars_Report(Customers[] ticket){
        return Parking.parkedCars_Report(ticket);
    }
    
    static String Payment_Report(ResultSet Resultset_for_customer){
        return adminMethod_inDatabase.Payment_Report(Resultset_for_customer);
    }
}
