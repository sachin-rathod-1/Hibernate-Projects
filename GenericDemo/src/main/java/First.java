import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class First extends GenericServlet {

	@Override
	public void service(ServletRequest arreqg0, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<html>"
				+ "<body> "
				+ "<b> Hello Sachin!!! </br> I am Generic Servlet </b> "
				+ "</body> "
				+ "</html> ");
	}
	
}


