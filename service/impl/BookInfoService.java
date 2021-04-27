package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.mysql.fabric.xmlrpc.base.Array;

import dao.BookInfoDaoInter;
import dao.impl.BookInfoDao;
import entity.BookInfo;
import service.BookInfoServiceInter;

public class BookInfoService implements BookInfoServiceInter {

	private BookInfoDaoInter bookInfoDao = new BookInfoDao();
	
	@Override
	public void addBookInfo(BookInfo bookInfo) {
		// TODO Auto-generated method stub
		int result = bookInfoDao.insert(bookInfo);
		if (result > 0) {
			System.out.println("新增成功！");
		}
		else {
			System.out.println("新增失败！");
		}
	}

	@Override
	public void removeBookInfo(int Rank) {
		// TODO Auto-generated method stub
		int result = bookInfoDao.delete(Rank);
		if (result > 0) {
			System.out.println("删除成功！");
		}
		else {
			System.out.println("删除失败！");
		}
	}

	@Override
	public void editBookInfo(BookInfo bookInfo, int Rank) {
		// TODO Auto-generated method stub
		int result = bookInfoDao.update(bookInfo, Rank);
		if (result > 0) {
			System.out.println("修改成功！");
		}
		else {
			System.out.println("修改失败！");
		}
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		List<BookInfo> list = bookInfoDao.select();
		if(list.size() > 0){
			for (BookInfo bookInfo2 : list) {
				System.out.print("排行："+bookInfo2.getRank() + "\t");
				System.out.print("标题："+bookInfo2.getTitle() + "\t");
				System.out.print("价格："+bookInfo2.getPrice() + "\t");
				System.out.print("出版社："+bookInfo2.getPress() + "\t");
				System.out.println();
			}
			System.out.println("查询成功！");
		}else {
			System.out.println("空表！");
		}
	}

	@Override
	public void getBookInfoByBid(int Rank) {
		// TODO Auto-generated method stub
		List<BookInfo> list = bookInfoDao.selectByBid(Rank);
		if(list.size() > 0){
			for (BookInfo bookInfo : list) {
				System.out.print("排行："+bookInfo.getRank() + "\t");
				System.out.print("标题："+bookInfo.getTitle() + "\t");
				System.out.print("价格："+bookInfo.getPrice() + "\t");
				System.out.print("出版社："+bookInfo.getPress() + "\t");
				System.out.println();
			}
		}else{
			System.out.println("没有该图书信息！");
		}
	}

	@Override
	public void getBookInfoByBame(String Title) {
		// TODO Auto-generated method stub
		List<BookInfo> list = bookInfoDao.selectByBname(Title);
		if(list.size() > 0){
			for (BookInfo bookInfo : list) {
				System.out.print("排行："+bookInfo.getRank() + "\t");
				System.out.print("标题："+bookInfo.getTitle() + "\t");
				System.out.print("价格："+bookInfo.getPrice() + "\t");
				System.out.print("出版社："+bookInfo.getPress() + "\t");
				System.out.println();
			}
		}else{
			System.out.println("没有该图书信息！");
		}
	}

	@Override
	public void recommend() {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		Random r = new Random();
		a[0] = r.nextInt(10); 
		for(int i = 1;i < 5;i++){//存入5个数,确保不重复
			a[i] = r.nextInt(10);
			for(int j = 0;j < i;j++){
				if(a[j]==a[i]){
					i--;
					break;
				}
			}
		}

		for (int i=0;i<5;i++) {
			List<BookInfo> list = bookInfoDao.selectByBid(a[i]);
			if(list.size() > 0){
				for (BookInfo bookInfo2 : list){
					System.out.print("排行："+bookInfo2.getRank() + "\t");
					System.out.print("标题："+bookInfo2.getTitle() + "\t");
					System.out.print("价格："+bookInfo2.getPrice() + "\t");
					System.out.print("出版社："+bookInfo2.getPress() + "\t");
					System.out.println();
				}
				
			}
		}
		
	}
}
