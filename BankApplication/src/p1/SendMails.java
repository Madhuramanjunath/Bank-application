package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Servlet implementation class SendMails
 */
public class SendMails extends HttpServlet {
	private Message mesg;

	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		String email=request.getParameter("email");
		
		
		String fromEmail="madhumadhurabm@gmail.com"; //sender's mail id.
		String pwd="1db15is017";		//sender's mail pwd.
	    String toEmail=request.getParameter("email");  //reciever's mail id.
		HttpSession session1=request.getSession();
		session1.setAttribute("email", email);
		
		String subject="Click here to reset your password"; // mail subject line
		String msg="http://localhost:9091/BankApplication/forgotPwdReset.jsp"; //mail body
		
		//Creating Session Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				//sender's mail id and pwd is encapsulated inside "SendersCredentials.java"
				return new PasswordAuthentication(fromEmail, pwd);
			}
		});

		
		try
		{
		//Composing the Mail
			MimeMessage mesg = new MimeMessage(session);
		mesg.setFrom(new InternetAddress(fromEmail));
		mesg.addRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
		mesg.setSubject(subject);  
		mesg.setText(msg);  
		
		//Sending the Mail
		Transport.send(mesg);
		System.out.println("Mail Sent!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try {
			response.sendRedirect("/BankApplication/forgotPwdDisp.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
