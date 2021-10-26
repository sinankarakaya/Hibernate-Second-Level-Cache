package com.sinan.HibernateCache.pojo;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "user")
@Cache(region = "userCache",usage = CacheConcurrencyStrategy.READ_WRITE)
public class User{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int userPK;
	@Column(name = "userName", nullable = true, length = 128)
	private String userName;
	@Column(name = "userPassword", nullable = true, length = 128)
	private String userPassword;
	@Column(name = "userRealName", nullable = true, length = 128)
	private String userRealName;
	
	public int getUserPK() {
		return userPK;
	}
	public void setUserPK(int userPK) {
		this.userPK = userPK;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	
}
