package service;

import java.util.List;

import dao.MyFileDAO;
import vo.MyFileDTO;

public class MyFileService implements MyFileServiceInter{
	
	//파일 업로드서비스
	@Override
	public void upload(MyFileDTO dto) {
		
		new MyFileDAO().insert(dto);
		
	}
	
	//파일 리스트서비스
	@Override
	public List<MyFileDTO> list() {
		
		return new MyFileDAO().list();
	}
	
	public long counter() {
		return new MyFileDAO().listCount();
	}
	
	
	public int delete(long idx) {
		return new MyFileDAO().delete(idx);
	}
	
	public String getName(long idx) {
		return new MyFileDAO().getName(idx);
	}
}
