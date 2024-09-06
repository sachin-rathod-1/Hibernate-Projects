package com.cdac.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.Action.EmployeeAction;
import com.cdac.Pojo.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String ename,email,pass,address;
		int salary;
		
		if(request.getParameter("addemp") != null) {
			ename=request.getParameter("ename");
			email=request.getParameter("email");
			pass=request.getParameter("pass");
			address=request.getParameter("address");
			salary=Integer.parseInt(request.getParameter("salary"));

			Employee employee=new Employee(ename,email,pass,address,salary);
			EmployeeAction ea=new EmployeeAction();
			int i=ea.addEmployee(employee);
			if(i>0) {
				
				out.println("<script>alert('Employee Registered Succesfully');</script>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else {
				out.println(" <script>alert('No Employee Registered');</script> ");
			}
		}
		
		if(request.getParameter("VieveEmployees") != null) {
			request.getRequestDispatcher("ViewEmpServlet").include(request, response);
		}
				
	}

}
