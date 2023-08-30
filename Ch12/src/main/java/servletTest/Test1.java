package servletTest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/test1")
public class Test1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Test1() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random rand = new Random();
		int num = rand.nextInt(11);
		//response.getWriter().append("Served at: "+num);
		//p443
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter(); //응답할 내용을
		writer.println("<!DOCTYPE html>");
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset=\"UTF-8\">");
		writer.println("<title>Insert title here</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>서블릿 넌 누구냐</h1>");
		writer.println("오늘의 숫자는:"+num);
		writer.println("</body>");
		writer.println("</html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
