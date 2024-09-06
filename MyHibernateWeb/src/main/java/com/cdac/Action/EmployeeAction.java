package com.cdac.Action;

import java.io.PrintWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.Pojo.Employee;
import com.cdac.Util.*;

public class EmployeeAction {

	private Transaction tran =null;
	private Session session=null;
	private int i=0;
	
	public int addEmployee(Employee employee) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tran=session.beginTransaction();
			i=(int)session.save(employee);
			tran.commit();
		}
		catch(HibernateException ex){
			if(tran != null) {
				tran.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
		return i;
	}
	public int deletEmployee(Employee e) {
		try {
			session=HibernateUtil.getSessionFactory().openSession();
			tran=session.beginTransaction();
			session.delete(e);
			tran.commit();
		}
		catch (RuntimeException ex) {
			if(tran != null) {
				tran.rollback();
			}
			ex.printStackTrace();
		}
		finally {
			session.flush();
			session.close();
		}
		return i;
	}
}
