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
			System.out.println("�����ɹ���");
		}
		else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	@Override
	public void removeBookInfo(int Rank) {
		// TODO Auto-generated method stub
		int result = bookInfoDao.delete(Rank);
		if (result > 0) {
			System.out.println("ɾ���ɹ���");
		}
		else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}

	@Override
	public void editBookInfo(BookInfo bookInfo, int Rank) {
		// TODO Auto-generated method stub
		int result = bookInfoDao.update(bookInfo, Rank);
		if (result > 0) {
			System.out.println("�޸ĳɹ���");
		}
		else {
			System.out.println("�޸�ʧ�ܣ�");
		}
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		List<BookInfo> list = bookInfoDao.select();
		if(list.size() > 0){
			for (BookInfo bookInfo2 : list) {
				System.out.print("���У�"+bookInfo2.getRank() + "\t");
				System.out.print("���⣺"+bookInfo2.getTitle() + "\t");
				System.out.print("�۸�"+bookInfo2.getPrice() + "\t");
				System.out.print("�����磺"+bookInfo2.getPress() + "\t");
				System.out.println();
			}
			System.out.println("��ѯ�ɹ���");
		}else {
			System.out.println("�ձ�");
		}
	}

	@Override
	public void getBookInfoByBid(int Rank) {
		// TODO Auto-generated method stub
		List<BookInfo> list = bookInfoDao.selectByBid(Rank);
		if(list.size() > 0){
			for (BookInfo bookInfo : list) {
				System.out.print("���У�"+bookInfo.getRank() + "\t");
				System.out.print("���⣺"+bookInfo.getTitle() + "\t");
				System.out.print("�۸�"+bookInfo.getPrice() + "\t");
				System.out.print("�����磺"+bookInfo.getPress() + "\t");
				System.out.println();
			}
		}else{
			System.out.println("û�и�ͼ����Ϣ��");
		}
	}

	@Override
	public void getBookInfoByBame(String Title) {
		// TODO Auto-generated method stub
		List<BookInfo> list = bookInfoDao.selectByBname(Title);
		if(list.size() > 0){
			for (BookInfo bookInfo : list) {
				System.out.print("���У�"+bookInfo.getRank() + "\t");
				System.out.print("���⣺"+bookInfo.getTitle() + "\t");
				System.out.print("�۸�"+bookInfo.getPrice() + "\t");
				System.out.print("�����磺"+bookInfo.getPress() + "\t");
				System.out.println();
			}
		}else{
			System.out.println("û�и�ͼ����Ϣ��");
		}
	}

	@Override
	public void recommend() {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		Random r = new Random();
		a[0] = r.nextInt(10); 
		for(int i = 1;i < 5;i++){//����5����,ȷ�����ظ�
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
					System.out.print("���У�"+bookInfo2.getRank() + "\t");
					System.out.print("���⣺"+bookInfo2.getTitle() + "\t");
					System.out.print("�۸�"+bookInfo2.getPrice() + "\t");
					System.out.print("�����磺"+bookInfo2.getPress() + "\t");
					System.out.println();
				}
				
			}
		}
		
	}
}
