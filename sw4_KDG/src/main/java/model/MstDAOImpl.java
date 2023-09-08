package model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MstDAOImpl extends DAOBase implements MstDAO {
	
	public MstDAOImpl() {}

	@Override
	public int inputProduct(MstVO vo) {
		int inputCheck = -1;
		String gcode = groupCode(vo.getGname());
		if(vo.getCode().equals("")) {
			return -1;
		}
		dbConn();
		try {
			pstmt = conn.prepareStatement("insert into product values (?, ?, ?, ?, ?, ?, ?)");
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getCost());
			pstmt.setInt(4, vo.getPnum());
			pstmt.setInt(5, vo.getJnum());
			pstmt.setInt(6, vo.getSale());
			pstmt.setString(7, gcode);
			inputCheck = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		dbClose();
		return inputCheck;
	}
	
	//그룹코드찾기
	@Override
	public String groupCode(String gname) {
		String gcode = "";
		dbConn();
		try {
			pstmt = conn.prepareStatement("select gcode from groupcode where gname = ?");
			pstmt.setString(1, gname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gcode = rs.getString(1);
				System.out.println(gcode);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return gcode;
	}

	@Override
	public MstVO searchProduct(String code) {
		MstVO vo = null;
		dbConn();
		try {
			pstmt = conn.prepareStatement("select code, pname, cost, pnum, jnum, sale, gname from product join groupcode using(gcode) where code = ?");
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new MstVO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), null, rs.getString(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return vo;
	}
	
	@Override
	public int modifyProduct(MstVO vo) {
		int result = -1;
		String gcode = groupCode(vo.getGname());
		dbConn();
		try {
			pstmt = conn.prepareStatement("update product set code = ?, pname = ?, cost = ?, pnum = ?, jnum = ?, sale = ?, gcode = ? where code = ?");
			pstmt.setString(1, vo.getCode());
			pstmt.setString(2, vo.getPname());
			pstmt.setInt(3, vo.getCost());
			pstmt.setInt(4, vo.getPnum());
			pstmt.setInt(5, vo.getJnum());
			pstmt.setInt(6, vo.getSale());
			pstmt.setString(7, gcode);	
			pstmt.setString(8, vo.getOgCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
		return result;
	}
	
	//삭제
	@Override
	public int deleteProduct(String code) {
		int result = -1;
		dbConn();
		try {
			pstmt = conn.prepareStatement("delete from product where code = ?");
			pstmt.setString(1, code);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();

		return result;
	}
	
	
	//그룹이름목록
	@Override
	public List<MstVO> groupName() {
		List<MstVO> list = new ArrayList<>();
		dbConn();
		try {
			pstmt = conn.prepareStatement("select gname, gcode from groupcode");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MstVO vo = new MstVO();
				vo.setGname(rs.getString(1));
				vo.setGcode(rs.getString(2));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		dbClose();
		return list;
	}

	@Override
	public List<MstVO> priorityProduct() {
		List<MstVO> list = new ArrayList<>();
		dbConn();
		try {
			pstmt = conn.prepareStatement("select pname, (pnum-jnum) priority from product where (pnum/jnum) > 5 order by priority desc");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MstVO vo = new MstVO();
				vo.setPname(rs.getString(1));
				vo.setPnum(rs.getInt(2));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dbClose();
		return list;
	}

	@Override
	public List<MstVO> benefitRank() {
		List<MstVO> list = new ArrayList<>();
		System.out.println("DAO.benefitRank");
		dbConn();
		try {
			pstmt = conn.prepareStatement("select pname, ((sale-cost) * jnum) benefit from product order by benefit desc");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MstVO vo = new MstVO();
				vo.setPname(rs.getString(1));
				vo.setCost(rs.getInt(2));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
		return list;
	}

	@Override
	public List<MstVO> jnumGroup() {
		List<MstVO> list = new ArrayList<>();
		dbConn();
		try {
			pstmt = conn.prepareStatement("select gname, sum(jnum) from groupcode join product using(gcode) group by gname");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MstVO vo = new MstVO();
				vo.setGname(rs.getString(1));
				vo.setJnum(rs.getInt(2));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		dbClose();
		return list;
	}



	

	

	

}
