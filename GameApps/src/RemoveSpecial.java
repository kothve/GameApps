import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveSpecial extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		
		
		String name = request.getParameter("game_name");
		String discount = "0";
		
		try {
			AdminOperation.updateDiscount(name, discount);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList specialList = LoadGames.SpecialGames();
		
		request.setAttribute("specialList", specialList);
        request.setAttribute("gameInt", 3);
        RequestDispatcher view = request.getRequestDispatcher("/AdminSpecials.jsp");
        view.forward(request, response);
	
	
	
	
	
	}

}
