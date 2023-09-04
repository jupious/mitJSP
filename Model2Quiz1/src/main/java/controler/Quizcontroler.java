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
public class Quizcontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		System.out.println(command);
		
		RequestDispatcher rd = null;
		
		String temp1 = request.getParameter("num1");
		String temp2 = request.getParameter("num2");
		int num1 = 0, num2 = 0;
		if(temp1 != null && temp2 != null) {
			 num1 = Integer.parseInt(temp1);
			 num2 = Integer.parseInt(temp2);
		}
		
		if(command.equals("/index.do")) {
			rd = request.getRequestDispatcher("index.jsp");
			
			
		}else if(command.equals("/even.do")) {
			Calc calc = new Calc(num1, num2);
			int even = calc.even();
			
			request.setAttribute("result", even);		
			rd = request.getRequestDispatcher("even.jsp");
		
		}else if(command.equals("/odd.do")) {
			Calc calc = new Calc(num1, num2);
			int odd = calc.odd();
			
			request.setAttribute("result", odd);
			rd = request.getRequestDispatcher("odd.jsp");
			
		}else {
			rd = request.getRequestDispatcher("error.jsp");
			
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
