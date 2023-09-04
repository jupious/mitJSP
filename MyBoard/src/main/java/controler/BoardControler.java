package controler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.mit.c305.gdg.BoardDBM;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.board")
public class BoardControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDBM db = new BoardDBM();
		boolean check = false;
		String command = request.getServletPath();
		RequestDispatcher rd = null;
		
		if(command.equals("/login.board")) {
			
			rd = request.getRequestDispatcher("Login.jsp");
		}else if(command.equals("/logincheck.board")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			check = db.loginCheck(id, pw);
			if(check) {
				response.sendRedirect("mainBoard.board");
			}else{
				System.out.println("ASDfasdfasdfasdfasdfasdf");
				request.setAttribute("loginFail", "로그인 실패! 아이디와 비밀번호를 확인해주세요");
				rd = request.getRequestDispatcher("loginfail.board");
			}
		}else if(command.equals("/mainBoard.board")) {
			rd = request.getRequestDispatcher("BoardMain.jsp");
			
		}else if(command.equals("/loginfail.board")) {
			String err = (String)request.getAttribute("loginFail");
			System.out.println("aaaa"+err);
			if(err != null) {	
				PrintWriter writer = response.getWriter();
				writer.println("<script>alert("+err+"); location.href='"+"login.board"+"';</script>"); //수정필요
				writer.close();
			}
			response.sendRedirect("");
		}
		
		if(rd != null) {
			rd.forward(request, response);
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
