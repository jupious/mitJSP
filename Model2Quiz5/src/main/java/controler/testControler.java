package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NameDB;
import model.NameVO;

import java.io.IOException;
import java.util.*;


public class testControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		if(command.equals("/test")) {
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}else if(command.equals("/list")){
			NameDB db = new NameDB();
			List<NameVO> list = new ArrayList<>();
			list = db.listLoad();
			request.setAttribute("Data", list);
			
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NameDB db = new NameDB();
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		name1 = name1.trim();
		name2 = name2.trim();
		int percent = db.getPercent(name1, name2);
	
		request.setAttribute("percent", percent);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
	}

}
