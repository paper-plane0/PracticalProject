package entity;

public class BookInfo {
	private int Rank;		//����
	private String Title;	//����
	private String Price;	//�۸�
	private String Press;	//������
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
	public BookInfo() {
		
	}
	public BookInfo(int rank, String title, String price, String press) {
		Rank = rank;
		Title = title;
		Price = price;
		Press = press;
	}
	
	
}
