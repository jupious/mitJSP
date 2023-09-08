package test;



import dao.MyFileDAO;

import vo.MyFileDTO;

public class MyFileTest {

	public static void main(String[] args) {
		MyFileDAO dao = new MyFileDAO();
		
		dao.insert(new MyFileDTO(null, "DAO테스트", "카테고리", "테스트원본.txt", "테스트저장본.txt", null));
		
		dao.list().forEach(x -> System.out.println(x));

	}

}
