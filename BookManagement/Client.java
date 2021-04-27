package view;

import java.util.List;
import java.util.Scanner;

import entity.BookInfo;
import service.BookInfoServiceInter;
import service.impl.BookInfoService;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		BookInfoServiceInter bookInfoService = new BookInfoService();
		BookInfo bookInfo = null;
		String message;
		BookInfo info;
		int Rank;
		String Title;
		String Price;
		String Press;
		while(true) {
			System.out.println("-------------------");
			System.out.println("|  欢迎使用图书信息管理系统   |");
			System.out.println("|1：删除                                 |");
			System.out.println("|2：查询                                 |");
			System.out.println("|3：搜索(编号)                       |");
			System.out.println("|4：搜索(书名)                       |");
			System.out.println("|5：推荐                                 |");
			System.out.println("|0：退出                                 |");
			System.out.println("-------------------");
			try {
				System.out.print("请选择功能(输入对应数字)：");
				int type = input.nextInt();
				switch(type) {
					case 1:
						System.out.print("请输入你要删除的书编号：");
						Rank = input.nextInt();
						bookInfoService.removeBookInfo(Rank);
						break;
					case 2:
						bookInfoService.getAll();
						break;
					case 3:
						try {
							System.out.print("请输入你要搜索的编号：");
							Rank = input.nextInt();
							bookInfoService.getBookInfoByRank(Rank);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("输入有误，请输入对应学号！");
							return;
						}
						break;
					case 4:
						try {
							System.out.print("请输入你要搜索的书名：");
							Title = input.next();
							bookInfoService.getBookInfoByTitle(Title);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("输入有误，请输入对应名字！");
							return;
						}
						break;
					case 5:
						try {
							System.out.println("图书推荐：");
							bookInfoService.recommend();
						} catch (Exception e) {
							// TODO: handle exception
							return;
						}
						break;
					case 0:
						System.out.println("系统退出");
						return;
					default:
						System.out.println("你的选择有误，请重新输入");
						break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("输入有误，请输入数字！");
				break;
			}
			
		}
	}

}

