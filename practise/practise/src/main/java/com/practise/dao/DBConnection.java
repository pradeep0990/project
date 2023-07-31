package com.practise.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    public Connection getConnection() {
	try{
	Properties p=new Properties();
	FileInputStream is=new FileInputStream("D:/works/practise/DBDetails.properties");
	p.load(is);
	Class.forName("com.mysql.cj.jdbc.Driver");
	return DriverManager.getConnection("jdbc:mysql://"+p.get("server")+":"+p.get("port")+"/"+p.get("uname")+"?autoReconnect=true&useSSL=false",""+p.get("uname"),""+p.get("password"));
	}
	catch(Exception e){
	    e.printStackTrace();
		return null;
	}    
    }
    public void editConnection(){
	
    }
    
}
