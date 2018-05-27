package edu.sabanciuniv.cs310.sumall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by denizmavi on 26.05.2018.
 */

public class DbManager {
    private Connection dbConn;

    public Connection getDbConn() {
        return dbConn;
    }

    DbManager()throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        //Replace below url according to local/remote Database.
        this.dbConn = DriverManager.getConnection("jdbc:mysql://cs308.cvy5zktpfpts.eu-west-3.rds.amazonaws.com/shopping_mall", "alkanv", "tevvez123456");

    }
}
