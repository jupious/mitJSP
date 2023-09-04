package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class Quiz3Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		RequestDispatcher rd = null;
		if(command.equals("/index.do")) {
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		RequestDispatcher rd = null;
		
		if(command.equals("/index.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			if(!id.equals("") && !pw.equals("")) {
				request.setAttribute("res", "가입가능");
			}else {
				request.setAttribute("res", "가입불가");
			}
			
			rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
