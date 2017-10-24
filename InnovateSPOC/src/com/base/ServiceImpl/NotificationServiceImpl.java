package com.base.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.DaoImpl.NotificationDaoImpl;
import com.base.Po.news;
import com.base.Po.teachers;
import com.base.Service.NotificationService;


@Service("notificationService")
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private NotificationDaoImpl notificationDaoImpl;
	
	
	@Override
	public void setNotification(String insertSql) {
		// TODO Auto-generated method stub
		notificationDaoImpl.setNotification(insertSql);
		return;
	}


	@Override
	public List getNotificationInfo(String currentPage,String itemsPerPage) {
		// TODO Auto-generated method stub
		
		return notificationDaoImpl.getNotificationInfo(currentPage,itemsPerPage);
	}


	public news getNotification(String id) {
		// TODO Auto-generated method stub
		return notificationDaoImpl.getNotification(id);
	}
	
	@Override
	public String delnews(int nid){
		String message= notificationDaoImpl.delnews(nid);
		return message;
	}


	@Override
	public List<news> getNews() {
		List<news> list= notificationDaoImpl.getNews();
		return list;
	}
}
