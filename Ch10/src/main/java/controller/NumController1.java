package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.mit.c305.DBClass;
import kr.mit.c305.ToDoClass;
import kr.mit.c305.ToDoVo;

import java.io.IOException;
import java.util.*;

@WebServlet("*.do")
public class NumController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//input1.do = 입력화면	(get)
	//result1.do = 처리	(post)


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//요청하는 url을 확인해서 처리
//		String str = request.getRequestURI(); //통합 자원 식별자 (identifier)
//		System.out.println("uri "+str);	//ex) /Ch10/aaa.do
//		
//		StringBuffer sb = request.getRequestURL(); //위치 (location)
//		System.out.println(sb); //ex) http://localhost:8081/Ch10/aaa.do
//		
//		HttpServletMapping hsm = request.getHttpServletMapping();
//		String test = hsm.getMatchValue();
//		System.out.println(test);	//aaa
//		
//		String cont = request.getContextPath();
//		System.out.println(cont);	// /Ch10
		
		
		String command = request.getServletPath();
		System.out.println(command);	// /aaa.do
		

		
		if(command.equals("/list.do")) {
			//보낼 데이터 가져오기
			DBClass db = new DBClass();
			List<ToDoVo> list = db.list();
			//보낼 데이터
			request.setAttribute("data", list);
			
			//페이지 여는법 2가지
			//1. 요청 url을 변경해서(새로운 요청) -리다이렉트 (주의)리퀘스트 영역에 데이터를 실어서 보내기때문에 리다이렉트를하면 데이터가 날아간다
			//response.sendRedirect("mvcView.jsp");
			//2. 요청 url을 유지하면서 - 디스패쳐 (포워드)

			RequestDispatcher rd = request.getRequestDispatcher("mvcView.jsp");
			rd.forward(request, response);
		}else if(command.equals("/test.do")) {
			response.sendRedirect("ELBasic.jsp");
		}else {
			response.sendRedirect("p347.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
