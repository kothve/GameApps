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
	
	
		String username = request.getParameter("blockusername");  
		String username1 = request.getParameter("unblockusername"); 
		
		
		if(!request.getParameter("blockusername").isEmpty()){
		IncrementLogging.Lock(username);
		request.setAttribute("Locked", "yes"); }
		
		else{
			
			IncrementLogging.Unlock(username1);
			request.setAttribute("Locked", "no"); 
		}
		
		
		
		
		
	
		
		
		
		
		
		 RequestDispatcher view = request.getRequestDispatcher("/AdminProfile.jsp");
         view.forward(request, response); 
		
		
	}

}
