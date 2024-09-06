package com.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.transform.Transformers;
import org.springframework.web.multipart.MultipartFile;

import com.model.UserRegistrationModel;

public class UserRegistrationDao {

	SessionFactory sessionFactory = null;
	Session session = null;
	
	public UserRegistrationDao()
	{
		sessionFactory =  new AnnotationConfiguration().configure().buildSessionFactory();
	}
	public String save(UserRegistrationModel userRegistrationModel,InputStream inputStream, MultipartFile file)
	{
		session = sessionFactory.openSession();
		try
		{
			Blob photo = Hibernate.getLobCreator(session).createBlob(inputStream, file.getSize());
			userRegistrationModel.setPhoto(photo);
			session.beginTransaction();
			session.save(userRegistrationModel);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
			return "error";
		}
		finally
		{
			if(session!=null)
				session.close();
			if(sessionFactory!=null)
				sessionFactory.close();
		}
		return "success";
	}
	public List<UserRegistrationModel> verifyUser(String email, String password)
	{
		List<UserRegistrationModel> userRegistrationModels= null;
		session = sessionFactory.openSession();
		Query query = session.createQuery(" SELECT urm.name AS name, "+ 
										  " urm.email AS email "+ 
										  " FROM UserRegistrationModel urm "+ 
										  " WHERE urm.password='"+password+"' "+ 
										  " AND urm.email='"+email+"' ").
										  setResultTransformer(Transformers.aliasToBean(UserRegistrationModel.class));
		//String query="from UserRegistrationModel where userName='"+email+"' And password='"+password+"'";
		//List<UserRegistrationModel> userRegistrationModels=session.createQuery(query).list();
		userRegistrationModels = query.list();
		return userRegistrationModels;
	}
}
