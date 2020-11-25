package day2;

import java.sql.*;

public class DisplayingAllDataFromAllColumns {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.89.238.187:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

        //print out entire first row of Employee table from above query
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        //print out column name in the begining row, then print first row
        for (int colNum = 1; colNum <= columnCount; colNum++){

            System.out.print(rsmd.getColumnLabel(colNum)+"\t");
        }
        System.out.println("--------------------------------------");
        rs.next();
        //this whole loop is getting one row of data
        for (int colNum = 1; colNum <= columnCount; colNum++){
            System.out.print(rs.getString( colNum) + "\t");
        }
    //now how do you get all the row if you know how to get one row??
        // I want to go from the first row till the last row and print all columns
        //System.out.println("---------------------------------------");

        rs.beforeFirst();

        while (rs.next()){
            for (int colNum = 1; colNum <= columnCount; colNum++){
                System.out.print(rs.getString( colNum) + "\t");
            }
            System.out.println();
        }
        rs.close();
        stmt.close();
        conn.close();




    }
}