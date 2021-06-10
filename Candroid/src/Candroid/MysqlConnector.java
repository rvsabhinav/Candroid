package Candroid;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author pranj
 */
public class MysqlConnector {
    
public MysqlConnector(){}
    
public ResultSet getResultSetFor(String query){
ResultSet rs = null;
try {
Class.forName("java.sql.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/candroid","root","0415");
Statement stmt=con.createStatement();
rs=stmt.executeQuery(query);
}
catch(Exception e)
{
    System.out.println(e);
}
return rs;
}

public void setSQLUpdate(String query){
try {
Class.forName("java.sql.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/candroid","root","0415");
Statement stmt=con.createStatement();
stmt.executeUpdate(query);
}
catch(Exception e)
{
    System.out.println(e);
}
}
public void setSQLInsert(String query){
try {
Class.forName("java.sql.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/candroid","root","0415");
Statement stmt=con.createStatement();
stmt.execute(query);
}
catch(Exception e)
{
    System.out.println(e);
}
}

public boolean isValidEmail(String id){
    boolean validity = true;    
    if(id.contains("@")&&id.contains(".")){
        int indexOfAt = id.indexOf("@"),indexOfDot=id.indexOf(".",indexOfAt);
        String chars = "~`!@#$%^&*()-=+[]{}\\|''\"\";:/?>,< ";
        String [] subs = new String[3];
        subs[0] = id.substring(0,indexOfAt);
        if(indexOfDot!=-1) subs[1] = id.substring(indexOfAt+1,indexOfDot);
        else return false;
        subs[2] = id.substring(indexOfDot+1);
        for(int j = 0;j<3;j++){
         for(int i=0;i<chars.length();i++)
              if(subs[j].contains(""+chars.charAt(i))) return false;
          if(j==2)
            if(!(subs[2].length()==3||subs[2].length()==2)) return false;
        }
    }
    else validity=false;   
    return validity;
    }
}