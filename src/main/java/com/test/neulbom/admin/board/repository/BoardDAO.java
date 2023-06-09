package com.test.neulbom.admin.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.neulbom.mylib.DBUtil3;

public class BoardDAO {
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public BoardDAO() {
		this.conn = DBUtil3.open();
	}
	
	//TODO
	// 글쓰기: 각 게시판-관리자 관계 테이블 참조 데이터 생성
	private int createWriter(String writer, String seq, String table) {
		return 0;
	}
	
	// 글 삭제: 각 게시판-관리자 관계 테이블 참조 데이터 null화
	private int updateWriter(String seq, String table) {

		try {

			String sql = "";

			switch (table) {
			case "notice":
				sql = "UPDATE tblAlert SET notice_seq = null WHERE notice_seq = ?";
				break;
			case "life":
				sql = "UPDATE tblAlert SET life_seq = null WHERE life_seq = ?";
				break;
			}

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			int result = pstat.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 공지게시판 글 삭제
	public int deleteNotice(String seq) {

		try {

			updateWriter(seq, "notice");

			String sql = "DELETE FROM tblNotice where notice_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return 0;
	}

	// 공지게시판 전체 글 출력
	public List<NoticeDTO> getNotice() {

		try {

			String sql = "select * from tblnotice order by notice_date desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<NoticeDTO> list = new ArrayList<NoticeDTO>();
			int i = 1;

			while (rs.next()) {

				NoticeDTO dto = new NoticeDTO();

				dto.setNotice_seq(rs.getString("notice_seq"));
				dto.setDisplayed_seq(i + "");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNotice_date(rs.getString("notice_date").substring(0, 10));
				dto.setRead(rs.getString("read"));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<FoodDTO> getFood() {
		try {

			String sql = "select * from tblfood order by food_date desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<FoodDTO> list = new ArrayList<FoodDTO>();
			int i = 1;

			while (rs.next()) {

				FoodDTO dto = new FoodDTO();

				dto.setFood_seq(rs.getString("food_seq"));
				dto.setDisplayed_seq(i + "");

				String temp = rs.getString("food_date").substring(5, 7);
				if (temp.startsWith("0"))
					temp = temp.substring(1);

				dto.setFood_month(temp);
				dto.setFood_date(rs.getString("food_date"));
				dto.setContent(rs.getString("content"));
				dto.setFood_date(rs.getString("food_date").substring(0, 10));
				dto.setRead(rs.getString("read"));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 공지게시판 글 조회
	public NoticeDTO showNotice(String seq) {

		try {

			String sql = "select * from tblnotice where notice_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();
			NoticeDTO dto = new NoticeDTO();

			while (rs.next()) {

				dto.setNotice_seq(rs.getString("notice_seq"));
				dto.setDisplayed_seq("-1");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNotice_date(rs.getString("notice_date").substring(0, 10));
				dto.setRead(rs.getString("read"));
			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 공지게시판 새 글 쓰기
	public int addNotice(String title, String content) {

		try {

			String sql = "INSERT INTO tblNotice VALUES (notice_seq.nextVal, ?, ?, sysdate, 0)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, title);
			pstat.setString(2, content);

			int result = pstat.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 공지게시판 수정: 기존 데이터 출력
	public NoticeDTO editNotice(String seq) {

		try {

			String sql = "SELECT * FROM tblNotice WHERE notice_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			NoticeDTO dto = new NoticeDTO();

			while (rs.next()) {

				dto.setNotice_seq(rs.getString("notice_seq"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setNotice_date(rs.getString("notice_date"));
				dto.setRead(rs.getString("read"));

			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 공지게시판 수정: 수정 사항 DB 반영
	public int editNotice(String seq, String title, String content) {
		try {

			String sql = "UPDATE tblNotice SET title=?, content=? WHERE notice_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, title);
			pstat.setString(2, content);
			pstat.setString(3, seq);
			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}

	// 생활게시판 전체 글 출력
	public List<LifeDTO> getLife() {

		try {

			String sql = "select * from tblLife order by life_date desc";

			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			List<LifeDTO> list = new ArrayList<LifeDTO>();
			int i = 1;

			while (rs.next()) {

				LifeDTO dto = new LifeDTO();

				dto.setLife_seq(rs.getString("life_seq"));
				dto.setDisplayed_seq(i + "");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRead(rs.getString("read"));
				dto.setLife_date(rs.getString("life_date").substring(0, 10));

				list.add(dto);
				i++;
			}

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 생활게시판 글 조회
	public LifeDTO showLife(String seq) {

		try {

			String sql = "select * from tblLife where life_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);

			rs = pstat.executeQuery();
			LifeDTO dto = new LifeDTO();

			while (rs.next()) {

				dto.setLife_seq(rs.getString("life_seq"));
				dto.setDisplayed_seq("-1");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setLife_date(rs.getString("life_date").substring(0, 10));
				dto.setRead(rs.getString("read"));
			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	// 생활게시판 수정: 기존 데이터 출력
	public LifeDTO editLife(String seq) {

		try {

			String sql = "SELECT * FROM tblLife WHERE life_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			rs = pstat.executeQuery();

			LifeDTO dto = new LifeDTO();

			while (rs.next()) {

				dto.setLife_seq(rs.getString("life_seq"));
				dto.setDisplayed_seq("-1");
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRead(rs.getString("read"));
				dto.setLife_date(rs.getString("life_date"));
			}

			return dto;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 생활게시판 수정: 수정 사항 DB 반영
	public int editLife(String seq, String title, String content) {
		try {

			String sql = "UPDATE tblLife SET title=?, content=? WHERE life_seq = ?";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, title);
			pstat.setString(2, content);
			pstat.setString(3, seq);
			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return 0;
	}

	// 생활게시판 새 글 쓰기
	public int addLife(String title, String content) {

		try {

			String sql = "INSERT INTO tblLife (life_seq, title, content, life_date, read) VALUES (life_seq.nextVal, ?, ?, sysdate, 0)";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, title);
			pstat.setString(2, content);

			int result = pstat.executeUpdate();

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;

	}

	// 생활게시판 글 삭제
	public int deleteLife(String seq) {
		
		try {

			updateWriter(seq, "life");

			String sql = "DELETE FROM tblLife where life_seq = ?";

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, seq);

			return pstat.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return 0;
	}
}
