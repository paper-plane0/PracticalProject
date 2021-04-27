package dao;

import java.util.List;

import entity.BookInfo;

public interface BookInfoDaoInter {
	public List<BookInfo> select();
	public int delete(int Rank);
	public List<BookInfo> selectByBid(int Rank);
	public List<BookInfo> selectByBname(String Title);
	public List<BookInfo> recommend();
}
