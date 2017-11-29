import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class blockUser  extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
	
	
		String username = request.getParameter("username");  
	
		IncrementLogging.Lock(username);
		
		
	
		
		request.setAttribute("Locked", "yes"); 
		
		
		
		 RequestDispatcher view = request.getRequestDispatcher("/AdminProfile.jsp");
         view.forward(request, response); 
		
		
	}

}
