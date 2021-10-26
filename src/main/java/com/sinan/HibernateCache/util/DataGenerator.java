package com.sinan.HibernateCache.util;

import java.util.UUID;

import org.hibernate.Session;

import com.sinan.HibernateCache.persistence.HibernateUtil;
import com.sinan.HibernateCache.pojo.User;

public class DataGenerator {

	
	public static void generateUser(int size) {
		Session session = HibernateUtil.Instance.getSession();
		session.beginTransaction();
		for(int i=0;i<size;i++) {
			User user = new User();
			user.setUserName(UUID.randomUUID().toString());
			user.setUserPassword(UUID.randomUUID().toString());
			user.setUserRealName(UUID.randomUUID().toString());
			session.save(user);
		}
		session.getTransaction().commit();
		session.close();
	}
}
