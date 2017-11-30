import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfo  extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
	
		
		String username = request.getParameter("username");  
		 ArrayList login = new ArrayList(); 
		
		String loginInfo = AdminCheck.getLastLogin(username);
		
		ArrayList<String> login1 = new ArrayList();
		login1.add(username);
		login1.add(loginInfo);
		login.add(login1);
		
		
		ArrayList purchaseList = new ArrayList();
		
		purchaseList = AdminCheck.userPurchase(username);
		request.setAttribute("Purchase", purchaseList); 
		
		
		
		
		request.setAttribute("LoginDate", login); 
		
		
		
		
		
		
		
		
		
		
		
		
		
		 RequestDispatcher view = request.getRequestDispatcher("/AdminProfile.jsp");
         view.forward(request, response); 
		
		
	}
}
