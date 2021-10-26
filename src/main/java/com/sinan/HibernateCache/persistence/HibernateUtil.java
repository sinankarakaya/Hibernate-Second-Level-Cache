package com.sinan.HibernateCache.persistence;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateUtil {
	
	Instance;
	
	private SessionFactory sessionFactory;

	private HibernateUtil() {
		sessionFactory =  new Configuration().configure().buildSessionFactory();
		Cache cache = sessionFactory.getCache();
		if (cache != null) {
		    cache.evictAllRegions(); 
		}
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.openSession();
	}
	
}
