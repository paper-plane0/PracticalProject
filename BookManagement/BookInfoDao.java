package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.BookInfoDaoInter;
import entity.BookInfo;

public class BookInfoDao implements BookInfoDaoInter {
	
	private BaseDao baseDao = new BaseDao();
	@Override
	public List<BookInfo> select() {
		// TODO Auto-generated method stub
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from JD";
		try {
			
			PreparedStatement pstmt = baseDao.getConn().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setRank(rs.getInt("rank"));
				bookInfo.setTitle(rs.getString("Title"));
				bookInfo.setPrice(rs.getString("Price"));
				bookInfo.setPress(rs.getString("Press"));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int delete(int Rank) {
		// TODO Auto-generated method stub
		int result = -1;
		String sql = "delete from JD where JD.Rank=?";
		try {
			PreparedStatement pstmt = baseDao.getConn().prepareStatement(sql);
			pstmt.setInt(1, Rank);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<BookInfo> selectByRank(int Rank) {
		// TODO Auto-generated method stub
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from JD where JD.Rank=? ";
		try {
			PreparedStatement pstmt = baseDao.getConn().prepareStatement(sql);
			pstmt.setInt(1, Rank);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setRank(rs.getInt("rank"));
				bookInfo.setTitle(rs.getString("title"));
				bookInfo.setPrice(rs.getString("price"));
				bookInfo.setPress(rs.getString("press"));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookInfo> selectByTitle(String Title) {
		// TODO Auto-generated method stub
		List<BookInfo> list = new ArrayList<BookInfo>();
		String sql = "select * from JD where Title like ?";
		
		try {
			PreparedStatement pstmt = baseDao.getConn().prepareStatement(sql);
			pstmt.setString(1, "%"+Title+"%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				BookInfo bookInfo = new BookInfo();
				bookInfo.setRank(rs.getInt("rank"));
				bookInfo.setTitle(rs.getString("title"));
				bookInfo.setPrice(rs.getString("price"));
				bookInfo.setPress(rs.getString("press"));
				list.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookInfo> recommend() {
		// TODO Auto-generated method stub
		
		return null;
	}

}