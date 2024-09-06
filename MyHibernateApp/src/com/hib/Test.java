package com.hib;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test tst=new Test();
		
		//Adding Records
//		tst.addUser("Sachin", "Rathod");
//		tst.addUser("Rahul", "Ishi");
//		tst.addUser("Shubham", "Patil");
//		tst.addUser("Girish", "Patil");
	   
//		tst.addTask(1, "Call", "Call Pankaj at 5 PM");
//		tst.addTask(1, "Shopping", "Buy some foods for Child");
//		tst.addTask(2, "Email", "Send birthday wish to Ankit");
//		tst.addTask(2, "SMS", "Send message to Friend");
//		tst.addTask(2, "Office", "Give a call to Boss"); 
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter ID and LastName");
//		int id=Integer.parseInt(sc.nextLine());
//		String lastName=sc.nextLine();
//		
//		/*Partial Updation */
//		tst.updateLastName(id, lastName);
//		
//		/*Full Record Updation */
//		 3wn
//		  User user = new User();
//		  user.setId(1);
//		  user.setFirstName("Sachin");
//		  user.setLastName("Rathod");
//		  tst.updateUser(user); 
//
//		//Get Full Name
	tst.getFullName("Sachin");
	
		 //Deleting Record
//		User user1 = new User();
//		user1.setId(3);
//		tst.deleteUser(user1);
		
		//To Delete All rows
		tst.deleteAllUseres();
	}
	private void deleteAllUseres() {
		Transaction trns=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		
		try {
			trns=session.beginTransaction();
			String hqldelete=(" DELETE FROM users where id = :did) ");
			int up=session.createQuery(hqldelete).setInteger("did", 7).executeUpdate();
			System.out.println(up);
			System.out.println("All rows deleted");
			trns.commit();		
		}
		catch(RuntimeException e){
			if(trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
	}
	
	private void addUser(String firstName,String lastName)
	{
		
	
		Transaction trns=null;
		Session session=HibernateUtil.getSessionFactory().openSession(); //hibernate.cfg.xml and user.hbm.xml included

		try
		{
		
			trns=session.beginTransaction();
			User user=new User();
			
			user.setFirstName(firstName);
			user.setLastName(lastName);
			
			session.save(user);
			session.getTransaction().commit();

		}
		catch (RuntimeException e) 
		{
			if(trns!=null)
			{
				trns.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	
	
	
	private void addTask(int userID, String title, String description)
	{
		Transaction trns=null;
		Session session=HibernateUtil.getSessionFactory().openSession();
		try
		{
			trns=session.beginTransaction();
			
			Task task=new Task();
			task.setUserID(userID);
			task.setTitle(title);
			task.setDescription(description);
			
			session.save(task);
			session.getTransaction().commit();
		}
		catch (RuntimeException e) 
		{
			if(trns!=null)
			{
				trns.rollback();
			}
			e.printStackTrace();
		}
		finally
		{
			session.flush();
			session.close();
		}
	}
	
	private void updateLastName(int id, String lastName) 
	{
		  Transaction trns = null;
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  try 
		  {
			  trns = session.beginTransaction();
			  String hqlUpdate = "update User u set u.lastName = :newLastName where u.id = :oldId";
			  int up = session.createQuery(hqlUpdate).setString("newLastName", lastName).setInteger("oldId", id).executeUpdate();
			  System.out.println(up);
			  trns.commit();
		  } 
		  catch (RuntimeException e) 
		  {
		   if(trns != null)
		   {
		    trns.rollback();
		   }
		   e.printStackTrace();
		  } finally{
		   session.flush();
		   session.close();
		  }
		 }
	private void updateUser(User user) 
	{
		  Transaction trns = null;
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  try 
		  {
			  trns = session.beginTransaction();
			  session.update(user);
			  trns.commit();
		  } 
		  catch (RuntimeException e) 
		  {
			  if(trns != null)
			  {
				  trns.rollback();
			  }
			  e.printStackTrace();
		  } finally{
		   session.flush();
		   session.close();
		  }
	}
		 
		private void getFullName(String firstName) 
		{
			 Transaction trns = null;
			 Session session = HibernateUtil.getSessionFactory().openSession();
			 try 
			 {
				 trns = session.beginTransaction();
				 List<User> users = session.createQuery("FROM User as u where u.firstName = :firstName").setString("firstName", firstName).list();
				 for (Iterator<User> iter = users.iterator(); iter.hasNext();) 
				 {
					 	User user = iter.next();
					 	System.out.println("ID="+user.getId()+"\nFirst Name:"+user.getFirstName() +"\nLast Name: " + user.getLastName());
				 }
				 trns.commit();
			 } 
			 catch (RuntimeException e) 
			 {
				 if(trns != null)
				 {
					 trns.rollback();
				 }
				 e.printStackTrace();
			 } 
			 finally
			 {
				 session.flush();
				 session.close();
			 }
		 }
		 private void deleteUser(User user) 
		 {
			 Transaction trns = null;
			 Session session = HibernateUtil.getSessionFactory().openSession();
			 try 
			 {
				 trns = session.beginTransaction();
				 session.delete(user);
				 trns.commit();
			 } 
			 catch (RuntimeException e) 
			 {
				 if(trns != null)
				 {
					 trns.rollback();
				 }
				 e.printStackTrace();
			 } 
			 finally
			 {
				 session.flush();
				 session.close();
			 }
		 }
}
