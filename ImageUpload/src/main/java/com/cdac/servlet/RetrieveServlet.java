package com.cdac.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveServlet
 */
@WebServlet("/RetrieveServlet")
public class RetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveServlet() {
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
		int id=Integer.parseInt(request.getQueryString());
		System.out.println(id);
		byte [] raw=null;
		response.setContentType("image/jpeg");
		
		ServletOutputStream out=response.getOutputStream();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dac","root","");
			Statement stmt=con.createStatement();
			String query="SELECT photo FROM student WHERE id="+id;
			ResultSet rs=stmt.executeQuery(query);
			rs.next();
			
			raw=rs.getBytes(1);
			out.write(raw);
			out.flush();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
