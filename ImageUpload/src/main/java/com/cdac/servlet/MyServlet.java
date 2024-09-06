package com.cdac.servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
@MultipartConfig(maxFileSize=16777215)
public class MyServlet extends HttpServlet 
{
	
    String message=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String sname=request.getParameter("sname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		InputStream inputStream=null;
		
		Part filePart=request.getPart("photo");
		if(filePart!=null)
		{
			System.out.println("File Name:"+filePart.getName());
			System.out.println("File Size:"+filePart.getSize());
			System.out.println("File Content Type:"+filePart.getContentType());
			
			inputStream=filePart.getInputStream();
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dac","root","");
			PreparedStatement ps=con.prepareStatement("INSERT INTO student(sname,email,mobile,photo)VALUES(?,?,?,?)");
			ps.setString(1, sname);
			ps.setString(2, email);
			ps.setString(3, mobile);

			ps.setBlob(4, inputStream);
			int i=ps.executeUpdate();
			if(i>0)
			{
			message="Image Uploaded Successfully";
			pw.print("Image Uploaded Successfully");

			}
		}
		catch(Exception e)
		{
			
			message="Error:"+e.getMessage();
			pw.print("Image Uploaded Not Successfully");
			e.printStackTrace();
		}
		request.setAttribute("message", message);
		/*RequestDispatcher rd=getServletContext().getRequestDispatcher("/Message.jsp");
		rd.forward(request, response); */
		getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	}
}