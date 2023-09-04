package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Calc;

import java.io.IOException;

@WebServlet("*.do")
public class AddControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		//System.out.println(command);
		
		
		
		if(command.equals("/index.do")) {
			response.sendRedirect("title.do");	
		}else if(command.equals("/title.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("title.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		RequestDispatcher rd = null;
		String temp1 = request.getParameter("num1");
		String temp2 = request.getParameter("num2");
		int num1 = 0, num2 = 0;
		if(temp1 != null && temp2 != null) {
			 num1 = Integer.parseInt(temp1);
			 num2 = Integer.parseInt(temp2);
		}
		
		if(command.equals("/add.do")) {
			Calc calc = new Calc();
			int add = calc.add(num1, num2);
			
			request.setAttribute("result", add);		
			rd = request.getRequestDispatcher("add.jsp");
			
		}else {
			rd = request.getRequestDispatcher("error.jsp");
			
		}
		if(rd != null)
			rd.forward(request, response);
	}

}
