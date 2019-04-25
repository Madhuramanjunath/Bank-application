package p1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetStatements
 */
public class GetStatements extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		
		
		Model m=new Model();
		m.setAccno(accno);
		
		m.getStatement();
		ArrayList al1=m.al1;
		ArrayList al2=m.al2;
		session.setAttribute("al1",al1);
		session.setAttribute("al2",al2);
		
		try {
			response.sendRedirect("/BankApplication/statementDisp.jsp");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		
	}
	
}
