package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VotingDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class InsertVoteServlet
 */
@WebServlet("/insertion")
public class InsertVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		response.setContentType("text/html");
		Voter v=(Voter)hs.getAttribute("voter_details");
		VotingDaoImpl dao=(VotingDaoImpl)hs.getAttribute("dao_details");
		try (PrintWriter pw=response.getWriter()){
			dao.insertVote(request.getParameter("nm"),v.getName());
			pw.write("<h1>You have successfully voted for "+request.getParameter("nm")+"</h1>");
		}catch (Exception e) {
			throw new ServletException("error in succ vote  do post",e);
		}
	}

}
