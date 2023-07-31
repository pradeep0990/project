package com.practise.dao;

import com.practise.model.Account;
import java.sql.*;

public class AccountDao extends DBConnection{
    public Account getAccountDetails(String email,String password){
	Account acc=new Account();
	try{
	    Connection con=getConnection();
	//Connection Check
	if(con!=null){
	    System.out.println("Connection Established");
	}
	else{
	    System.out.print("Error");
	}
	PreparedStatement ins=con.prepareStatement("select * from User_Details where email=?");
	ins.setString(1,email);
	ResultSet rs=ins.executeQuery();
	while(rs.next()){ 
	    if(rs.getString(2).equals(password)){
		acc.setUserName(rs.getString(1));
		acc.setPassword(rs.getString(2));
		acc.setEmail(rs.getString(3));
		acc.setPhno(rs.getString(4));
		acc.setRoom_Name(rs.getString(5));
	    }
	    break;
	}
	con.close();
	return acc;
	}
	catch(Exception e){ 
	   e.printStackTrace();
	}
	return acc;
	}
    
    public String insertAccountDetails(String name,String password,String email,String phno,String room){
	try{
	    if(!verifyUser(email)){
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net :3306/sql12356041?autoReconnect=true&useSSL=false","sql12356041","TdbCNR3wnI");
	//Connection Check
		if(con!=null){
		    System.out.println("Connection Established");
		}
		else{
		    System.out.print("Error");
		}
	PreparedStatement ins=con.prepareStatement("insert into User_Details values(?,?,?,?,?)");
	ins.setString(1,name);
	ins.setString(2,password);
	ins.setString(3,email);
	ins.setString(4,phno);
	ins.setString(5,room);
	ins.execute();
	con.close();
	System.out.print("inserted");
	return "Inserted";
	    }
	    else{
		return "created User";
	    }
	}
	catch(Exception e){ 
	   e.printStackTrace();
	   return "Data Error";
	}

	}
    public boolean verifyUser(String email){
	try{
	    Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net :3306/sql12356041?autoReconnect=true&useSSL=false","sql12356041","TdbCNR3wnI");
	PreparedStatement ins=con.prepareStatement("select * from User_Details where email=?");
	ins.setString(1,email);
	ResultSet rs=ins.executeQuery();
	while(rs.next()){
	    return true;
	}
	return false;
	}
	catch(Exception e){
	    e.printStackTrace();
	}
	return false;
    }
    
}
