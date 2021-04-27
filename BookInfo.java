package entity;

public class BookInfo {
	private int Rank;		//排行
	private String Title;	//标题
	private String Price;	//价格
	private String Press;	//出版社
	public int getRank() {
		return Rank;
	}
	public void setRank(int rank) {
		Rank = rank;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getPress() {
		return Press;
	}
	public void setPress(String press) {
		Press = press;
	}

	public BookInfo(int rank, String title, String price, String press) {
		Rank = rank;
		Title = title;
		Price = price;
		Press = press;
	}
	
	
}
