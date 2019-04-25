package p1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ForgotPwdReset
 */
public class ForgotPwdReset extends HttpServlet {
	protected void service(HttpServletRequest request,HttpServletResponse response)
	{
		String newpwd=request.getParameter("newpwd");
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		Model m=new Model();
		m.setNewpwd(newpwd);
		m.setEmail(email);
		int x=m. forgotPwd();
		if(x==1)
		{
			try {
				response.sendRedirect("/BankApplication/successForgotPwdReset.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		{
			try {
				response.sendRedirect("/BankApplication/errorForgotPwd.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
