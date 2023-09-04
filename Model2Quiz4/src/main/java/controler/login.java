package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comm = request.getServletPath();
		System.out.println(comm);
		
		if(comm.equals("/index.jsp")) {
			request.getRequestDispatcher("title.jsp").forward(request, response);
		}else if(comm.equals("/login.login")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");	
		
		if(id.equals("admin") && pw.equals("admin")) {
			rd = request.getRequestDispatcher("sucess.jsp");
		}else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
	
		
		if(rd != null) {
			rd.forward(request, response);
		}
	}

}
