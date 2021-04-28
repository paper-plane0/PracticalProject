package service;


import entity.BookInfo;

public interface BookInfoServiceInter {
	
	public void removeBookInfo(int Rank);
	public void getAll();
	public void getBookInfoByRank(int Rank);
	public void getBookInfoByTitle(String Title);
	public void recommend();
}
