package com.cdac.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		
		out.println("<html><head><title>Image Display</title></head><body>");
		out.println("<table width='100%' height=auto>");
		out.println("<tr><td>Student ID</td><td>Student Name</td><td>Email ID</td><td>Mobile</td><td>Image</td></tr>");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dac","root","");
			Statement stmt=con.createStatement();
			String query="SELECT * FROM student";
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("id");
				out.println("<tr>");
				out.println("<td>"+id+"</td>");
				out.println("<td>"+rs.getString("sname")+"</td>");
				out.println("<td>"+rs.getString("email")+"</td>");
				out.println("<td>"+rs.getString("mobile")+"</td>");
				out.println("<td><img src='"+"RetrieveServlet?"+id+"' width='70px' height='70px' /></td>");
				out.println("</tr>");
			}
			out.println("</table></body></html>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}