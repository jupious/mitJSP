package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.MyFileService;
import vo.MyFileDTO;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@MultipartConfig
//옵션 maxFileSize : 한 파일의 최대 크기 = long 기본값 -1L 제한없음
//	   maxRequestSize: 한번에 올리는 파일들의 최대크기(총합) = long 기본값 -1L 제한없음
//	   location: 파일의 저장하기 위한 위치 
//	   filesizeThreshold : 메모리 임시저장 크기 = int 기본값 0 - 바로써짐
public class MyFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		
		if(command.equals("/downloadList.do")) {
			MyFileService service = new MyFileService();
			request.setAttribute("List",  service.list());
			request.setAttribute("Count", service.counter());
			
			request.getRequestDispatcher("dboard/downloadList.jsp").forward(request, response);
		}else if(command.equals("/upload.do")) {
			request.getRequestDispatcher("dboard/upload.jsp").forward(request, response);
		}else {
			System.out.println("잘못된 url요청");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getServletPath();
		//request.setCharacterEncoding(CHARSET);
		if(command.equals("/uploadpro.do")) {
			//multipart/form-data form으로 보낼때
			//어노테이션필요하고
			//파일만 별개로 처리하면된다

			String title = request.getParameter("title");
			String[] cateArr = request.getParameterValues("cate");
			String cate = "";	
			
			if(cateArr != null) {
				for (String str : cateArr) {
					cate += str +", ";
				}
			}else {
				cate = "카테고리 없음(까먹었거나)";
			}
			
			giveMeFile(request,response,title, cate);
			//데이터 도배방지
			response.sendRedirect("downloadList.do");
		}else if(command.equals("/delete.do")) {
//			String flag = request.getParameter("flag");
//			
//			if(flag.equals("true")) {
				MyFileService service = new MyFileService();
				long idx = Long.parseLong(request.getParameter("idx"));
				String sfile = service.getName(idx);
				
				String fileDir = request.getServletContext().getRealPath("/upload");
				String filePath = fileDir+File.separator+sfile;
				File file = new File(filePath);
				System.out.println("filePath : "+filePath);
				if(file.exists()) {
					file.delete();
				}
				
				service.delete(idx);
		//	}else if(flag.equals("none")) {
//				request.setAttribute("msg", "delete");
//				request.setAttribute("idx", Long.parseLong(request.getParameter("idx")));
//				request.getRequestDispatcher("alert.jsp").forward(request, response);
//			}
//			
			response.sendRedirect("downloadList.do");
			
			
			
		}
	}
	
	protected void giveMeFile(HttpServletRequest request, HttpServletResponse response, String title, String cate) throws IOException, ServletException {

		
		Part filePart =  request.getPart("ofile");
		String ofile = filePart.getSubmittedFileName();
		String header = filePart.getHeader("content-disposition");
		String uuid = UUID.randomUUID().toString();
		String sfile = uuid+"_"+ofile;
		String saveDir = request.getServletContext().getRealPath("/upload");
		System.out.println(saveDir);
		if(!ofile.isEmpty())	//파일명이 빈값이 아니라면
			filePart.write(saveDir + File.separator+sfile);
		
		
		System.out.println(header);
		new MyFileService().upload(new MyFileDTO(null, title, cate, ofile, sfile, null));
	}

}
