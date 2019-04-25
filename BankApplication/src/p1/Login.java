package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		String custid=request.getParameter("custid");
		String pwd=request.getParameter("pwd");
		Model m=new Model();
		m.setCustid(custid);
		m.setPwd(pwd);
		boolean status=m.login();
		if(status==false)
		{
			try {
				response.sendRedirect("/BankApplication/failLogin.jsp");
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			
			try
			{
				String accno=m.getAccno();
				HttpSession session=request.getSession();
				session.setAttribute("accno", accno);
				response.sendRedirect("/BankApplication/home.jsp");
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
