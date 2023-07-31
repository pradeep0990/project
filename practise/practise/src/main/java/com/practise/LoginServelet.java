package com.practise;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practise.dao.AccountDao;
import com.practise.dao.ViewDetailsDao;
import com.practise.model.Account;

@SuppressWarnings("serial")
public class LoginServelet extends HttpServlet {

public  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    AccountDao dao=new AccountDao();
    Account a1=dao.getAccountDetails(email,password);
    if(a1.getUserName()==null)
    {
	request.setAttribute("errorMessage", "Invalid Credentials");
	request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    else{
	    ViewDetailsDao viewList=new ViewDetailsDao();
	    request.setAttribute("list",viewList.viewDetails());
	    RequestDispatcher rd=request.getRequestDispatcher("showDetails.jsp");
	    rd.forward(request, response);
    }
    
}

}
