package test;

import service.MyFileService;
import vo.MyFileDTO;

public class MyFileServiceTest {

	public static void main(String[] args) {

		MyFileService service = new MyFileService();
		
		service.upload(new MyFileDTO(null, "Service테스트", "Service카테고리", "Service원본.txt", "Service저장본.txt", null));
		
		service.list().forEach(x -> System.out.println(x));

	}

}
