package controler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//test요청이 오면
		List<Student> list = new ArrayList<>();

		for(int i = 0; i < 10; i++) {
			Student student = new Student(i+"이름", i+"", "010"+i+"");
			list.add(student);
		}
		request.setAttribute("List", list);
		request.getRequestDispatcher("jstltest.jsp").forward(request, response);
	}


}
