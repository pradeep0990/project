package com.practise;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.practise.ejb.MailSender;

import javax.ejb.EJB;
import javax.ejb.Local;
 

public class ResetPassword extends HttpServlet {
    	@EJB
    	private MailSender sender=new MailSender();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toEmail=request.getParameter("email");
		String fromEmail="murtypradeep99@gmail.com";
		String userName="murtypradeep99";
		String password="ASDasd123@";
		String subject="Password Reset";
		String content="Hi"+toEmail+ "Please click Here to reset password";
		
		sender.sendmail(fromEmail, userName, password, toEmail, subject, content);
		request.setAttribute("status", "mail sent");
		request.setAttribute("toEmail", toEmail);
		request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
		
	}

}
