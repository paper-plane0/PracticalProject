package service;


import entity.BookInfo;

public interface BookInfoServiceInter {
	public void addBookInfo(BookInfo userInfo);
	public void removeBookInfo(int Rank);
	public void editBookInfo(BookInfo bookInfo, int Rank);
	public void getAll();
	public void getBookInfoByBid(int Rank);
	public void getBookInfoByBame(String Bname);
	public void recommend() ;
}
