package day3;

import utility.DB_Utility;

import java.sql.ResultSet;

public class UtilityPractice {
    public static void main(String[] args) {
        //test out all the methods you have created so far for practice
        DB_Utility.createConnection();

        ResultSet jobRs = DB_Utility.runQuery("SELECT * FROM JOBS");

    }
}
