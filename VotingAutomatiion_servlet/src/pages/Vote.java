package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class Vote
 */
@WebServlet("/vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//Retrieving the values of the user from session
		HttpSession hs=request.getSession();
		Voter v=(Voter)hs.getAttribute("voter_details");
		System.out.println("in vote dopost"+v.getStatus());
		if(v.getStatus()==0) {
			try(PrintWriter pw=response.getWriter()){
				pw.write("<h1>Welcome "+v.getName()+"</h1>"+" <br><h1>Choose your preffered candidate.</h1>");
					VotingDaoImpl dao=(VotingDaoImpl)hs.getAttribute("dao_details");
					ArrayList<String>al=dao.vote();
					pw.write("<form action='insertion'method='post'>");
						for(String s:al) {
							System.out.println(s);
							pw.write("<input type='radio'name='nm' value='"+s+"'>"+s+"<br>");
						}
						pw.write("<br><input type='submit'>");
					pw.write("</form>");
					}
					catch (Exception e) {
						throw new ServletException("err in vote do-get",e);
					}
					
		}
		else {
			try(PrintWriter pw=response.getWriter()){
				pw.write("<h1 style='background-color:red'>You have already voted and cannot vote again</h1>");
			}
		}
				
			
		 
		
	}

}
