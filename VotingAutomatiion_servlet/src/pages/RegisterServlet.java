package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.VotingDaoImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotingDaoImpl dao;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			dao=new VotingDaoImpl();
		} catch (Exception e) {
			throw new ServletException("error in register init",e);
		}
	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		if(dao!=null)
			try {
				dao.cleanUp();
			} catch (Exception e) {
				throw new RuntimeException("err in Register destroy",e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("pass enterd"+request.getParameter("pass"));
			int i=dao.register(request.getParameter("name"),request.getParameter("email"),request.getParameter("pass"));
			try(PrintWriter pw=response.getWriter()){	
				if(i==1) 
					pw.write("<h1>You have successfully registered.<br><a href='index.html'> Click here </a> to login </h1>");
				else
					pw.write("<h1>Registraion failed</h1>");
			}
		} catch (Exception e) {
			throw new ServletException("err in register dopost",e);
		}
		
	}

}
