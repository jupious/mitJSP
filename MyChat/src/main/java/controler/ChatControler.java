package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ChatDAO;
import model.ChatVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ChatControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		
		if(command.equals("/login.chat")) {
			HttpSession session =  request.getSession();
			if( session.getAttribute("chatUser") == null || ((String)session.getAttribute("chatUser")).equals("")) {
				request.getRequestDispatcher("loginChat.jsp").forward(request, response);
			}else {
				response.sendRedirect("chatmain.chat");
			}
			
		}else if(command.equals("/chatmain.chat")) {
			HttpSession session =  request.getSession();
			ChatDAO dao = new ChatDAO();
			List<ChatVO> list = dao.list();
			if( session.getAttribute("chatUser") == null || ((String)session.getAttribute("chatUser")).equals("")) {
				request.setAttribute("msg", "wrongAccess");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}else {
				if(list.size() != 0) {
					request.setAttribute("chatlog", list);
				}
				request.getRequestDispatcher("chatmain.jsp").forward(request, response);
			}
			
		}else if(command.equals("/signup.chat")) {
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}else if(command.equals("/logout.chat")) {
			System.out.println("로그아웃 요청됨");
			request.getSession().setAttribute("chatUser", "");
			response.sendRedirect("login.chat");
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
		}
	}

}
