package com.practise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.practise.dao.AccountDao;
import com.practise.dao.ViewDetailsDao;


@SuppressWarnings("serial")
public class Registration extends HttpServlet {
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("Username");
		String password=request.getParameter("Userpassword");
		String confPassword=request.getParameter("confirmPassword");
		String email=request.getParameter("Email");
		String number=request.getParameter("Phno");
		String room=request.getParameter("room");
		AccountDao a1=new AccountDao();
		String action=a1.insertAccountDetails(username,password,email,number,room);
		if(action.equals("Inserted")){
		    ViewDetailsDao viewList=new ViewDetailsDao();
		    request.setAttribute("list",viewList.viewDetails());
		    request.getRequestDispatcher("showDetails.jsp").forward(request, response);
		}
		if(action.equals("created User")){
		    request.setAttribute("Message", "Sorry mate you already have an Account:(");
		    request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		if(action.equals("Data Error")){
		    request.setAttribute("Message", "Bro you have entered something wrong ;)");
		    request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
	}
	}

