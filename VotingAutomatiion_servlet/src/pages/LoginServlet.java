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
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/validate")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VotingDaoImpl dao;
	
	public void init(ServletConfig config) throws ServletException {
		try {
			dao=new VotingDaoImpl();
			System.out.println("in login init");
		} catch (Exception e) {
			throw new ServletException("error in int",e);
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
				throw new RuntimeException("error in destroy",e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creating a session for a new request
		HttpSession hs=request.getSession();
		
		//calling the validate method of the dao layer to validate user details
		try {
			Voter v=dao.validate(request.getParameter("email"), request.getParameter("pass"));
			//System.out.println("in login dopost"+v.getStatus());
			//System.out.println(v);
			if(v!=null) {
				//if login is successful, saving details in session
				hs.setAttribute("voter_details",v);
				hs.setAttribute("dao_details",dao);
				//redirecting to voting page after successful login
				response.sendRedirect("vote");
			}
			else {
				try(PrintWriter pw=response.getWriter()){
					//in case of unsuccessful login, prompting user about incorrect credentials
					pw.write("<h1>Invalid Username/Password<br><a href='index.html'>Try again</a></h1>");
				}
			}
		} catch (Exception e) {
			throw new ServletException("err in loginserv do post",e);
		}
		
	}

}
