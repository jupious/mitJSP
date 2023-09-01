package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.mit.c305.DBClass;
import kr.mit.c305.ToDoClass;
import kr.mit.c305.ToDoVo;

import java.io.IOException;
import java.util.*;


public class NumController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//input1.do = 입력화면	(get)
	//result1.do = 처리	(post)


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//보낼 데이터 가져오기
		DBClass db = new DBClass();
		List<ToDoVo> list = db.list();
		
		
		//보낼 데이터
		request.setAttribute("data", list);
		
		//페이지 여는법 2가지
		//1. 요청 url을 변경해서(새로운 요청) -리다이렉트
		//response.sendRedirect("p347.jsp");
		//2. 요청 url을 유지하면서 - 디스패쳐 (포워드)

		RequestDispatcher rd = request.getRequestDispatcher("mvcView.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
