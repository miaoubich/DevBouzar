package Data_Base;

import java.net.Socket;
import java.sql.*;

public class DATA_BASE {
    
    Connection connection;
    Statement statement;
    String SQL;
   
    String url;
    String username;
    String password;
    Socket client;
    int Port;
    String Host;

  
    public DATA_BASE(String url, String username, String password, String Host, int Port){
        
        this.url = url;// url="jdbc:mysql://localhost:3306/stock_management";
        this.username = username;// username="root";
        this.password = password;// password="";
        this.Host = Host;
        this.Port = Port;
    }
    
    //function to connect to database for mysql is "com.mysql.jdbc.Driver"
    public Connection connexionDatabase(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");//load the driver
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e){ 
            System.err.println(e.getMessage());//"e.getMessage()" shows where the error is.
                                               //"err" to print the error.
        }
        return connection;
    }
    
    //to close DATA BASE connection
    public Connection closeconnexion(){
        
        try{
            connection.close();
        } catch (Exception e){
            System.err.println(e);//
        }
        return connection;
    }
    
    //to execute the querry
    public ResultSet exécutionQuery(String sql) {
        connexionDatabase();
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);
        } catch (SQLException ex){
            System.err.println(ex);//
        }
        return resultSet;
    }
    
    //to execute an updated querry
    public String exécutionUpdate(String sql) {
        connexionDatabase();
        String result = "";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = sql;

        } catch (SQLException ex){
            result = ex.toString();
        }
        return result;
    }
    
    //to print all "SELECT * FROM"
    public ResultSet querySelectAll(String myTable){

        connexionDatabase();
        SQL = "SELECT * FROM " + myTable;
        System.out.println(SQL);
        return this.exécutionQuery(SQL);
    }
    
    //Overload query execution function to select all columns with where
     public ResultSet querySelectAll(String nomTable, String état){
        connexionDatabase();
        SQL = "SELECT * FROM " + nomTable + " WHERE " + état;
        return this.exécutionQuery(SQL);
    }
     
     //Query execution function to select the specific columns
     public ResultSet querySelect(String[] nomColonne, String myTable) {

        connexionDatabase();
        int i;
        SQL = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1){
                SQL += ",";
            }
        }

        SQL += " FROM " + myTable;
        return this.exécutionQuery(SQL);
    }
     
     //Overload query execution function to select the specific columns with where
     public ResultSet fcSelectCommand(String[] nomColonne, String myTable, String état) {
        connexionDatabase();
        int i;
        SQL = "SELECT ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }

        SQL += " FROM " + myTable + " WHERE " + état;
        return this.exécutionQuery(SQL);
    } 
    
     
     public String queryInsert(String nomTable, String[] contenuTableau) {

        connexionDatabase();
        int i;
        SQL = "INSERT INTO " + nomTable + " VALUES(";

        for (i = 0; i <= contenuTableau.length - 1; i++) {
            SQL += "'" + contenuTableau[i] + "'";
            if (i < contenuTableau.length - 1) {
                SQL += ",";
            }
        }

        SQL += ")";
        return this.exécutionUpdate(SQL);

    }
     
     //fonction to insert data
     public String queryInsert(String nomTable, String[] nomColonne, String[] contenuTableau) {//queryInsert("sales", colon, sales_data))

        connexionDatabase();
        int i;
        SQL = "INSERT INTO " + nomTable + "(";
        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i];
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }
        SQL += ") VALUES(";
        for (i = 0; i <= contenuTableau.length - 1; i++) {
            SQL += "'" + contenuTableau[i] + "'";
            if (i < contenuTableau.length - 1) {
                SQL += ",";
            }
        }

        SQL += ")";
        return this.exécutionUpdate(SQL);

    }
     
    //fonction for querry update
     public String queryUpdate(String nomTable, String[] nomColonne, String[] contenuTableau, String état) {

        connexionDatabase();
        int i;
        SQL = "UPDATE " + nomTable + " SET ";

        for (i = 0; i <= nomColonne.length - 1; i++) {
            SQL += nomColonne[i] + "='" + contenuTableau[i] + "'";
            if (i < nomColonne.length - 1) {
                SQL += ",";
            }
        }

        SQL += " WHERE " + état;
        return this.exécutionUpdate(SQL);

    }
     
     //fontion for querry delete without parameter
     public String queryDelete(String nomtable) {

        connexionDatabase();
        SQL = "DELETE FROM " + nomtable;
        return this.exécutionUpdate(SQL);

    }
     //fonction delete with parameter
     public String queryDelete(String nomTable, String état) {

        connexionDatabase();
        SQL = "DELETE FROM " + nomTable + " WHERE " + état;
        return this.exécutionUpdate(SQL);

    }
     
}

