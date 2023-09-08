package service;

import java.util.List;

import vo.MyFileDTO;

public interface MyFileServiceInter {
	//파일 업로드서비스
	void upload(MyFileDTO dto);
	
	//파일 리스트서비스
	List<MyFileDTO> list();
	
	//파일 다운로드서비스
}
