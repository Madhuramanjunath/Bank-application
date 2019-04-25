package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**f
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
	{
		String raccno=request.getParameter("raccno");
		String amount=request.getParameter("amount");
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		Model m=new Model();
		m.setRaccno(raccno);
		m.setAmount(amount);
		
		
		m.setAccno(accno);
		boolean status=m.transfer();
		if(status==true)
		{
			try
			{
				response.sendRedirect("/BankApplication/successTransfer.jsp");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		else
		{
			try
			{
				response.sendRedirect("/BankApplication/failTransfer.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
