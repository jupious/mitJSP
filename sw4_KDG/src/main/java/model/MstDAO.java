package model;

import java.util.List;

public interface MstDAO {
	//제품 입력
	int inputProduct(MstVO vo);
	//제품 조회
	MstVO searchProduct(String code);
	//제품 수정
	int modifyProduct(MstVO vo);
	//제품 삭제
	int deleteProduct(String code);
	//그룹이름
	List<MstVO> groupName();
	//그룹코드 반환
	String groupCode(String gname);
	//우선생산제품
	List<MstVO> priorityProduct();
	//이익순위
	List<MstVO> benefitRank();
	//그룹별재고수량
	List<MstVO> jnumGroup();

}
