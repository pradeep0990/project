package com.practise.ejb;

import java.util.Properties;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Session Bean implementation class MailSender
 */
@Stateless
@LocalBean
public class MailSender {

  public void sendmail(String fromEmail,String username,String password,String toEmail,String subject,String content){
      try {
      Properties prop=System.getProperties();
      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.auth", "true");
      prop.put("mail.smtp.port", "465");
      prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      prop.put("mail.smtp.socketFactory.port", "465");
      prop.put("mail.smtp.socketFactory.fallback", "false");
      
      Session mailSession=Session.getDefaultInstance(prop, null);
      mailSession.setDebug(true);
      
      Message mailSender=new MimeMessage(mailSession);
      
      mailSender.setFrom(new InternetAddress(fromEmail));
      mailSender.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
      mailSender.setSubject(subject);
      mailSender.setContent(content, "text/html");
      
      Transport trans=mailSession.getTransport("smtp");
      trans.connect("smtp.gmail.com", username, password);
      trans.sendMessage(mailSender, mailSender.getAllRecipients());
	
    } catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
      
      
  }

}
