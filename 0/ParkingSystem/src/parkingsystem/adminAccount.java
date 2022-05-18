package parkingsystem;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.sql.DriverManager;

public class adminAccount {
    
    static boolean LogIn(ResultSet Resultset_for_admin, Admins newAdmin){
        try{
            Resultset_for_admin.beforeFirst();
            while(Resultset_for_admin.next()){
                if(newAdmin.getAdminName().equals(Resultset_for_admin.getString(1)) && newAdmin.getAdminPassword().equals(Resultset_for_admin.getString(2))){
                    return true;
                }
            }

        }
        catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        return false;
    }
}
