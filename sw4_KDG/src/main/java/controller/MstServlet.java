package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MstDAO;
import model.MstDAOImpl;
import model.MstVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.mst")
public class MstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MstServlet() {

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		System.out.println(command);
		if(command.equals("/search.mst")) {
			MstDAO dao = new MstDAOImpl();
			request.setAttribute("gnameList", dao.groupName());
			
			String code = request.getParameter("code");
			MstVO vo = dao.searchProduct(code);
			request.setAttribute("result", vo);
			
			request.getRequestDispatcher("search.jsp").forward(request, response);
		}else if(command.equals("/mainMenu.mst")) {
			request.getRequestDispatcher("mainMenu.jsp").forward(request, response);
		}else if(command.equals("/productin.mst")) {
			MstDAO dao = new MstDAOImpl();
			request.setAttribute("gnameList", dao.groupName());
			
			request.getRequestDispatcher("productin.jsp").forward(request, response);
		}else if(command.equals("/input.mst")) {
			MstDAO dao = new MstDAOImpl();
			
			String code = request.getParameter("code");
			String pname = request.getParameter("pname");
			int cost = Integer.parseInt(request.getParameter("cost"));
			int pnum = Integer.parseInt(request.getParameter("pnum"));
			int jnum = Integer.parseInt(request.getParameter("jnum"));
			int sale = Integer.parseInt(request.getParameter("sale"));
			String gname = request.getParameter("gname");
			System.out.println("gname = " + gname);
			
			MstVO vo = new MstVO(code, pname, cost, pnum, jnum, sale, null, gname);
			if(dao.inputProduct(vo) == 1) {
				System.out.println("입력완료");
				request.setAttribute("msg", "insert");
			}else {
				System.out.println("입력오류발생");
				request.setAttribute("msg", "inserterror");
				
			}
			request.getRequestDispatcher("alert.jsp").forward(request, response);
		}else if(command.equals("/priority.mst")) {
			MstDAO dao = new MstDAOImpl();
			List<MstVO> list = dao.priorityProduct();
			if(list.size() != 0) {
				request.setAttribute("priorityList", list);
				request.getRequestDispatcher("priorityproduct.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "listerror");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}
	
		}else if(command.equals("/benefit.mst")) {
			MstDAO dao = new MstDAOImpl();
			List<MstVO> list = dao.benefitRank();
			System.out.println("이익순위들어옴");
			if(list.size() != 0) {
				System.out.println("에러발생");
				request.setAttribute("benefitList", list);
				request.getRequestDispatcher("benefitrank.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "listerror");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}
		}else if(command.equals("/remain.mst")) {
			MstDAO dao = new MstDAOImpl();
			List<MstVO> list = dao.jnumGroup();
			if(list.size() != 0) {
				request.setAttribute("remainList", list);
				request.getRequestDispatcher("remain.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "listerror");
				request.getRequestDispatcher("alert.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		
		if(command.equals("/modify.mst")) {
			String code = request.getParameter("code");
			String pname = request.getParameter("pname");
			int cost = Integer.parseInt(request.getParameter("cost"));
			int pnum = Integer.parseInt(request.getParameter("pnum"));
			int jnum = Integer.parseInt(request.getParameter("jnum"));
			int sale = Integer.parseInt(request.getParameter("sale"));
			String gname = request.getParameter("gname");
			String ogCode = request.getParameter("ogCode");
			
			MstVO vo = new MstVO(code, pname, cost, pnum, jnum, sale, null, gname);
			vo.setOgCode(ogCode);
			MstDAO dao = new MstDAOImpl();
			if(dao.modifyProduct(vo) == 1) {
				System.out.println("수정완료");
				request.setAttribute("msg", "modify");
			}else {
				System.out.println("수정오류발생");
				request.setAttribute("msg", "modifyerror");
			}
			
			request.getRequestDispatcher("alert.jsp").forward(request, response);
		}else if(command.equals("/delete.mst")) {
			System.out.println("삭제화면들어옴");
			MstDAO dao = new MstDAOImpl();
			
			String code = request.getParameter("code");
			if(dao.deleteProduct(code) == 1) {
				System.out.println("삭제완료");
				request.setAttribute("msg", "delete");
			}else {
				System.out.println("삭제오류발생");
				request.setAttribute("msg", "deleteerror");
			}
			request.getRequestDispatcher("alert.jsp").forward(request, response);
			
		}
		
	}

}
