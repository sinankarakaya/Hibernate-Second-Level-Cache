package com.sinan.HibernateCache;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sinan.HibernateCache.persistence.HibernateUtil;
import com.sinan.HibernateCache.pojo.User;
import com.sinan.HibernateCache.util.DataGenerator;


public class App {
	
    public static void main( String[] args ){
    	
    	List<User> users;
    	
    	users = getUsers();
    	users = getUsers();
    	DataGenerator.generateUser(1);
    	users = getUsers();
    	
    	
    	User user = findById_entity(1);
    	user = findById_entity(1);
    	DataGenerator.generateUser(1);
    	user = findById_entity(1);
    	
    	
    	
    	user = findById_criteria(1);
    	user = findById_criteria(1);
    	DataGenerator.generateUser(1);
    	user = findById_criteria(1);
    	
    	
    	
    	user = findById_entity(1);
    	user = findById_entity(1);
    	updateUser(user);
    	user = findById_entity(1);
    	
    	
    	System.out.println("");
    }
    
    
    public static List<User> getUsers(){
    	Session session = HibernateUtil.Instance.getSession();
    	session.beginTransaction();
    	
    	Criteria criteria = session.createCriteria(User.class);
    	criteria.setCacheable(true);
    	List<User> users = criteria.list();
    	
    	session.getTransaction().commit();
    	session.close();
    	return users;
    }
    
    public static User findById_criteria(int id) {
    	Session session = HibernateUtil.Instance.getSession();
    	session.beginTransaction();
    	
    	Criteria criteria = session.createCriteria(User.class);
    	criteria.add(Restrictions.eq("userPK", 1));
    	criteria.setCacheable(true);
    	List<User> users = criteria.list();
    	
    	session.getTransaction().commit();
    	session.close();
    	return users.size()==0 ? null : users.get(0);
    }
    
    public static User findById_entity(int id) {
    	Session session = HibernateUtil.Instance.getSession();
    	session.beginTransaction();
   
    	User user = session.find(User.class, 1);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	return user;
    }
    
    public static void updateUser ( User user) {
    	Session session = HibernateUtil.Instance.getSession();
    	session.beginTransaction();
    	user.setUserName(UUID.randomUUID().toString());
    	session.update(user);
    	
    	session.getTransaction().commit();
    	session.close();
    }
}
