package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ApplyLoan
 */
public class ApplyLoan extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		
		boolean status=m.loan();
		if(status==true)
		{
			String name=m.getName();
			session.setAttribute("name",name );
			String email=m.getEmail();
			session.setAttribute("email", email);
			System.out.println("name"+name);
			System.out.println("email"+email);
			try
			{
				response.sendRedirect("/BankApplication/loanDisp.jsp");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
	}

}
