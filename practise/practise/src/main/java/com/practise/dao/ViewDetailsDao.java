package com.practise.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.practise.model.Account;

public class ViewDetailsDao extends DBConnection {
    
public ArrayList<Account> viewDetails(){
    ArrayList<Account> list=new ArrayList<Account>();
    Account acc[];
    try{
	Connection con=getConnection();
	if(con!=null)
	    System.out.println("Connection Established");
	else
	    System.out.print("Error");
	PreparedStatement ins=con.prepareStatement("select * from User_Details");
	ResultSet rs=ins.executeQuery();
	int rowcount=0;
	while(rs.next())
	    rowcount++;
	acc=new Account[rowcount];
	int count=0;
	rs.first();
	rs.previous();
	while(rs.next()){
	    	acc[count]=new Account();
		acc[count].setUserName(rs.getString(1));
		acc[count].setPassword(rs.getString(2));
		acc[count].setEmail(rs.getString(3));
		acc[count].setPhno(rs.getString(4));
		acc[count].setRoom_Name(rs.getString(5));
		list.add(acc[count]);
		count++;	    
	}
	con.close();
	return list;
	}
	catch(Exception e){ 
	   e.printStackTrace();
	   return null;
	}
    //Account account[]=new Account[list.size()];
    //list.toArray(account);
   
}
}
