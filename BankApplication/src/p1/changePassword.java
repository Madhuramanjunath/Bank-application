package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class changePassword
 */
public class changePassword extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		Model m=new Model();
		m.setAccno(accno);
		m.setOldpwd(oldpwd);
		m.setNewpwd(newpwd);
		int status=m.changePwd();
		if(status==0)
		{
		
				try {
					response.sendRedirect("/BankApplication/failChangePwd.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		else
		{
		
				try {
					response.sendRedirect("/BankApplication/successChangePwd.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
}
