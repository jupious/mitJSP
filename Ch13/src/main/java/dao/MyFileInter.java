package dao;

import java.util.List;
import vo.MyFileDTO;

public interface MyFileInter {

	List<MyFileDTO> list();				//전체리스트 db에서 가져오기
	void insert(MyFileDTO dto);			//db에 데이터 저장하기
}
