package day2;

import java.sql.*;

public class Review {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@3.89.238.187:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(connectionStr, username, password);

        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmt.executeQuery("SELECT * FROM JOBS");

        //I want to read the first row
        rs.next();
        System.out.println("First column value in Jobs "+rs.getString(1));
        System.out.println("Second column value in Jobs "+rs.getString(2));


        //Move to row number 7 and get above 2 columns values
        rs.absolute(7);
        System.out.println("First column value in Jobs in row 7  "+rs.getString(1));
        System.out.println("Second column value in Jobs in row 7 "+rs.getString(2));

        rs.last();
        System.out.println("First column value in Jobs in last row   "+rs.getString(1));
        System.out.println("Second column value in Jobs in last row   "+rs.getString(2));

        rs.previous();

        System.out.println("First column value in Jobs in 2nd row  from last row   "+rs.getString(1));
        System.out.println("Second column value in Jobs in 2nd row from  last row   "+rs.getString(2));

        System.out.println("------------Loop from first row till last row print JOB_ID--------------------");

        rs.beforeFirst();

        while (rs.next()){
            System.out.println("Loop First Column "+rs.getString("JOB_ID"));
        }

        System.out.println("------------Loop from last row till first row to get MIN_SALARY Column AS NUMBER--------------");

        //WE ARE CURRENTLY AT AFTER LAST LOCATION
        //if you want to make sure and explicitly say so
        //we can do below

        rs.afterLast();
        while (rs.previous()){
            //NOTHING WRONG WITH GETTING IT AS STRING, JUST FOR THE SAKE OF DEMO, WE ARE GETTING AS DOUBLE
            System.out.println("MIN SALARY COLUMN AS NUMBER $"+ rs.getDouble("MIN_SALARY"));
        }

        //clean up the connection, statement and result set object after usage
        rs.close();
        stmt.close();
        conn.close();




    }
}