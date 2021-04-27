package dao;

import java.util.List;

import entity.BookInfo;

public interface BookInfoDaoInter {
	public List<BookInfo> select();
	public int delete(int Rank);
	public List<BookInfo> selectByRank(int Rank);
	public List<BookInfo> selectByTitle(String Title);
	public List<BookInfo> recommend();
}
