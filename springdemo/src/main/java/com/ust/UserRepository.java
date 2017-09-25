package com.ust;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ust.entity.Bookmark;
import com.ust.entity.User;

public class UserRepository {
	
	public static void main(String[] args) {
//		Bookmark bookmark = new Bookmark("google.com");
//		User user = new User("Ravi");
//		List<Bookmark> bookmarks = new ArrayList<>();
//		bookmarks.add(bookmark);
//		
//		user.setBookmarks(bookmarks);
		
		UserRepository repository = new UserRepository();
//		repository.addUser(user);
		
		User user = repository.findUser(1);
		System.out.println(user);
	}
	
//	Step1. Create EMF
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("myjpa"); 

	
	public void addUser(User user){
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
			em.persist(user);
		transaction.commit();
		em.close();
	}
	
	public User findUser(int id){
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		User user = em.find(User.class, id);
		System.out.println(user);
		transaction.commit();
		em.close();
		return user;
	}
}
