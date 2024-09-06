import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

public class EmployeeTest 
{
   private static SessionFactory sessionFactory; 
   public static void main(String[] args) 
   {
      try
      {
    	  //Read Session Factory from hibernate.cfg.xml
         sessionFactory = new Configuration().configure().buildSessionFactory();
   
      }
      catch (Throwable ex) 
      { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      EmployeeTest employee = new EmployeeTest();
     
      HashSet set1 = new HashSet();
      set1.add(new Certificates("CCNA"));
      set1.add(new Certificates("CCNP"));
      set1.add(new Certificates("RHCE"));
      set1.add(new Certificates("MCTS"));
      
      Integer id1 = employee.addEmployee("Mohit", "Kumar", 5000, set1);

      HashSet set2 = new HashSet();
      set2.add(new Certificates("PG-DAC"));
      set2.add(new Certificates("DASDM"));

      Integer id2 = employee.addEmployee("Rahul", "Kumar", 60, set2);
     
    //  employee.updateEmployee(1, 15);
     // employee.listEmployees();
      //employee.deleteEmployee(1);
     // employee.listEmployees();
   }
   public Integer addEmployee(String fname, String lname, int salary, Set cert)
   {
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try
      {
         tx = session.beginTransaction();
         Employee employee = new Employee(fname, lname, salary);
         employee.setCertificates(cert);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      }
      catch (HibernateException e) 
      {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   public void listEmployees()
   {
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();)
         {
            Employee employee = (Employee) iterator1.next(); 
            System.out.println("Employee ID: "+employee.getId());
            System.out.print("First Name: " + employee.getFirstName()); 
            System.out.print(" Last Name: " + employee.getLastName()); 
            System.out.println(" Salary: " + employee.getSalary());
            Set certificates = employee.getCertificates();
            for(Iterator iterator2 = certificates.iterator(); iterator2.hasNext();)
            {
                  Certificates certName = (Certificates) iterator2.next(); 
                  System.out.println("Certificate: " + certName.getName()); 
            }
         }
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   public void updateEmployee(Integer EmployeeID, int salary)
   {
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary(salary);
         session.update(employee);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   public void deleteEmployee(Integer EmployeeID)
   {
      Session session = sessionFactory.openSession();
      Transaction tx = null;
      try{
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
}