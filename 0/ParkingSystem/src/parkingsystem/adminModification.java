package parkingsystem;

import java.sql.*;
import java.util.*;
import java.sql.Date;
import java.sql.DriverManager;

public class adminModification {
    
    static void addAdmin(ResultSet Resultset_for_admin, Admins[] admin, Admins newAdmin){
        for(int index_of_adminsArray = 0; index_of_adminsArray < admin.length; index_of_adminsArray++){
            if(admin[index_of_adminsArray].getAdminPassword() == null){
                admin[index_of_adminsArray].setAdminName(newAdmin.getAdminName());
                admin[index_of_adminsArray].setAdminPassword(newAdmin.getAdminPassword());
                break;
            }
        }
        adminMethod_inDatabase.addAdminInDatebase(Resultset_for_admin, newAdmin);
    }
        
    static void updateAdminPassword(ResultSet Resultset_for_admin, Admins[] admin, Admins newAdmin){
        for(int index_of_adminsArray = 0; admin[index_of_adminsArray].getAdminPassword() != null; index_of_adminsArray++){
            if(admin[index_of_adminsArray].getAdminName().equals(newAdmin.getAdminName())){
                admin[index_of_adminsArray].setAdminPassword(newAdmin.getAdminPassword());
                break;
            }                                         
        }
        adminMethod_inDatabase.updatePasswordAdminInDatebase(Resultset_for_admin, newAdmin);
    }
    
    static void deleteAdmin(ResultSet Resultset_for_admin, String adminName){
        adminMethod_inDatabase.deleteAdmin(Resultset_for_admin, adminName);
    }
}
