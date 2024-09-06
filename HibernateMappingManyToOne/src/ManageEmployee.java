import java.util.*;
 
import org.hibernate.*;
import org.hibernate.cfg.*;

public class ManageEmployee 
{
   private static SessionFactory factory; 
   public static void main(String[] args) 
   {
      try
      {
         factory = new Configuration().configure().buildSessionFactory();
      }
      catch (Throwable ex) 
      { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManageEmployee ME = new ManageEmployee();

    Address address = ME.addAddress("Rajasthan","Jaipur","RAJ","12345");
   
      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, address);
      Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, address);
      Integer empID3 = ME.addEmployee("Ramesh", "Kumar", 4000, address);
      Integer empID4 = ME.addEmployee("Rajesh", "Kumar", 3000, address);
      
    // Address a =new Address();
   // ME.updateAddress(1,"Jodhpur");
      ME.listEmployees();

    //  ME.updateEmployee(1, 5000);
 
     // ME.deleteEmployee(1);

     // ME.listEmployees();
   }
  
public Address addAddress(String street, String city, String state, String zipcode) 
   {
      Session session = factory.openSession();
      Transaction tx = null;
       Integer addressID = null;
      Address address = null;
      try{
         tx = session.beginTransaction();
         address = new Address(street, city, state, zipcode);
         addressID = (Integer) session.save(address); 
         System.out.println("Address ID:"+addressID);
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return address;
   }
private void updateAddress(int i, String city) {
	   Session session = factory.openSession();
	      Transaction tx = null;
	       Integer addressID = null;
	       try {
		tx=session.beginTransaction();
		Address a = (Address)session.get(Address.class, i); 
		 
		 a.setCity(city);
	    	session.update(a);   
	    	   tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	
}
   public Integer addEmployee(String fname, String lname, int salary, Address address)
   {
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      try{
         tx = session.beginTransaction();
         Employee employee = new Employee(fname, lname, salary, address);
         employeeID = (Integer) session.save(employee); 
         tx.commit();
      }catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
      return employeeID;
   }
   public void listEmployees()
   {
      Session session = factory.openSession();
      Transaction tx = null;
      try
      {
         tx = session.beginTransaction();
         List employees = session.createQuery("FROM Employee").list();
         for (Iterator iterator = employees.iterator(); iterator.hasNext();)
         {
            Employee employee = (Employee) iterator.next(); 
            System.out.print("First Name:"+employee.getFirstName()); 
            System.out.print("Last Name:"+employee.getLastName()); 
            System.out.println("Salary:"+employee.getSalary());
            Address add = employee.getAddress();
            System.out.println("Address ");
            System.out.println("Street:"+add.getStreet());
            System.out.println("City:"+add.getCity());
            System.out.println("State:"+add.getState());
            System.out.println("Zipcode:"+add.getZipcode());
         }
         tx.commit();
      }catch(HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      }finally {
         session.close(); 
      }
   }
   public void updateEmployee(Integer EmployeeID, int salary)
   {
      Session session = factory.openSession();
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
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
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