package day1;

import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) throws SQLException {
        // REPLACE THIS IP ADDRESS WITH YOUR OWN THAT WORKING IN SQL DEVELOPER
        String connectionStr = "jdbc:oracle:thin:@3.89.238.187:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        //rs.next(); method will return boolean value
        // if there is next row---->> return true and move the pointer to next row
        //if there is no next row -->> false

        while( rs.next()){
            //System.out.println("Region_ID " + rs.getString("Region_ID"));
            //System.out.println("Region_Name "+ rs.getString("Region_Name"));
        }
       // Iterate over all Countries
        rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");
      //  rs.next();
      //  System.out.println(rs.getString(1));

        while (rs.next() ){
            System.out.println(rs.getString(1)+" "+ rs.getString(2)+" "+rs.getString(3));
        }

        rs.previous();
    }
}
