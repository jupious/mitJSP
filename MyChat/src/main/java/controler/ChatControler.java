package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChatDAO;

import java.io.IOException;
import java.io.PrintWriter;


public class ChatControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		
		if(command.equals("/login.chat")) {
			request.getRequestDispatcher("loginChat.jsp").forward(request, response);
		}else if(command.equals("/chatmain.chat")) {
			
			request.getRequestDispatcher("chatmain.jsp").forward(request, response);
		}else if(command.equals("/signup.chat")) {
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		System.out.println(command);
		if(command.equals("/logincheck.chat")) {
			ChatDAO db = new ChatDAO();
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			if(db.userCheck(name, pw)) {
				System.out.println("로그인성공함!");
				request.getSession().setAttribute("chatUser", name);
				response.sendRedirect("chatmain.chat");
			}else {
				System.out.println("로그인실패함!");
				request.setAttribute("msg", "logfail");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}
		}else if(command.equals("/signuptry.chat")) {
			ChatDAO db = new ChatDAO();
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			if(db.signUp(name, pw)) {
				request.setAttribute("msg", "signupsuccess");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
				//alert 전용 페이지 하나 만들어서 결과마다 처리하기 테스트 ㄱ
			}else {
				request.setAttribute("msg", "signupfail");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}
		}else if(command.equals("/sendchat.chat")) {
			System.out.println("여기는왔냐");

			String text = request.getParameter("text");

			System.out.println(text);

			request.setAttribute("text", text);
			request.getRequestDispatcher("chatmain.jsp").forward(request, response);
		}else if(command.equals("/chatmain.chat")) {
			System.out.println("설마 여기로옴???");
		}
	}

}
