package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ChatDB;

import java.io.IOException;
import java.io.PrintWriter;


public class ChatControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private boolean Flag = true;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		if(command.equals("/login.chat")) {
			if(Flag == false) {
				Flag = true;
				PrintWriter writer = response.getWriter();
				writer.println("<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<script>\r\n"
						+ "	alert('이름 또는 비밀번호를 확인해주세요.'); location.href='"+"login.chat"+"';\r\n"
						+ "	</script>\r\n"
						+ "</head>\r\n"
						+ "</html>");
				writer.close();
			}
			request.getRequestDispatcher("loginChat.jsp").forward(request, response);
		}else if(command.equals("/chatmain.chat")) {
			
			request.getRequestDispatcher("chatmain.jsp").forward(request, response);
		}else if(command.equals("/signup.chat")) {
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();

		if(command.equals("/logincheck.chat")) {
			ChatDB db = new ChatDB();
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			if(db.userCheck(name, pw)) {
				Flag = true;
				request.getSession().setAttribute("chatUser", name);
				response.sendRedirect("chatmain.chat");
			}else {
				Flag = false;
				response.sendRedirect("login.chat");
			}
		}else if(command.equals("/signuptry.chat")) {
			ChatDB db = new ChatDB();
			String name = request.getParameter("name");
			String pw = request.getParameter("pw");
			if(db.signUp(name, pw)) {
				request.getRequestDispatcher("login.chat");
				//alert 전용 페이지 하나 만들어서 결과마다 처리하기 테스트 ㄱ
			}else {
				PrintWriter writer = response.getWriter();
				writer.println("<html>\r\n"
						+ "<head>\r\n"
						+ "<meta charset=\"UTF-8\">\r\n"
						+ "<script>\r\n"
						+ "	alert('이미 존재하는 이름입니다.'); location.href='"+"signup.chat"+"';\r\n"
						+ "	</script>\r\n"
						+ "</head>\r\n"
						+ "</html>");
				writer.close();
			}
		}
	}

}
