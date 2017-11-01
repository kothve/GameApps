
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class Search extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String url = "jdbc:mysql://localhost/soen387";
    	String username = "o_mercie";
    	String password = "odette";
    	
    	
    	
    	
    	
    
 
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection con=DriverManager.getConnection(url,username,password); 
            //System.out.println("Connected!");
        	
        	
        	
        	
        	
        	
            String game_Id = request.getParameter("game_Id");
            
            String game_Name = request.getParameter("game_Name");
            String console = request.getParameter("console");
            String genre = request.getParameter("genre");
            String year = request.getParameter("year");
            String developer = request.getParameter("developer");
            String publisher = request.getParameter("publisher");
            
            ArrayList al = null;
            
            ArrayList gameList = new ArrayList();
            int gameInt = 1;
            
            
            
            int[] isNotEmpty = {0,0,0,0,0,0,0};
             
            String[] selections = new String[7];
            selections[0] = game_Id;
            selections[1] = game_Name;
            selections[2] = console;
            selections[3] = genre;
            selections[4] = year;
            selections[5] = developer;
            selections[6] = publisher;
            
 
            
            String[] columnName = new String[7];
            columnName[0] = "games_id";
            columnName[1] = "game_name";
            columnName[2] = "console";
            columnName[3] = "genre";
            columnName[4] = "release_date";
            columnName[5] = "developer";
            columnName[6] = "publisher";
           
             String statement = ""; 
             
             
             
             
             
             
            if(!request.getParameter("game_Id").isEmpty()){
            	
            	isNotEmpty[0] =1;
            	
            	statement = "select * from games where "+ columnName[0]+"=?";
            	
            	
            	
            	
            }
            
            
            
            
            
            
            if(!request.getParameter("game_Name").isEmpty() ){
            	
            	isNotEmpty[1] = 1 ;
            	
            	
            	if(isNotEmpty[0] == 1){
            		
            		
            		statement = statement+" and "+  columnName[1]+"=?";
            		
            		
            		
            	}
            	
            	
            	
            	else if(isNotEmpty[0] == 0) {
            		
            		statement = "select * from games where "+  columnName[1]+"=?";
            		
            	}
            	
            	
            	
            	
            	
            }
           
            if(!request.getParameter("console").isEmpty()){
            	
            	isNotEmpty[2] = 1 ;
            	
            	
            	if(isNotEmpty[0] == 1 || isNotEmpty[1] == 1 ){
            		
            		
            		statement = statement+" and "+  columnName[2]+"=?";
            		
            		
            		
            	}
            	
            	else {
            		
            		statement = "select * from games where "+  columnName[2]+"=?";
            		
            	}           	
            	
            	
            }
            
            if(!request.getParameter("genre").isEmpty()){
            	
            	
            		isNotEmpty[3] = 1 ;
            	
            	
            	if(isNotEmpty[0] == 1 || isNotEmpty[1] == 1 || isNotEmpty[2] == 1 ){
            		
            		
            		statement = statement+" and "+  columnName[3]+"=?";
            		
            		
            		
            	}
            	
            	else {
            		
            		statement = "select * from games where "+  columnName[3]+"=?";
            		
            	}          	
            	
            }
            
            
           
            if(!request.getParameter("year").isEmpty()){
            	
            	
        		isNotEmpty[4] = 1 ;
        	
        	
        	if(isNotEmpty[0] == 1 || isNotEmpty[1] == 1 || isNotEmpty[2] == 1 || isNotEmpty[3] == 1  ){
        		
        		
        		statement = statement+" and substring("+  columnName[4]+",1 ,4 )=?";
        		
        		
        		
        	}
        	
        	else {
        		
        		statement = "select * from games where substring("+  columnName[4]+",1 ,4 )=?";
        		
        	}          	
        	
        }
            
if(!request.getParameter("developer").isEmpty()){
            	
            	
        		isNotEmpty[5] = 1 ;
        	
        	
        	if(isNotEmpty[0] == 1 || isNotEmpty[1] == 1 || isNotEmpty[2] == 1 || isNotEmpty[3] == 1 || isNotEmpty[4] == 1  ){
        		
        		
        		statement = statement+" and "+  columnName[5]+"=?";
        		
        		
        		
        	}
        	
        	else {
        		
        		statement = "select * from games where "+  columnName[5]+"=?";
        		
        	}          	
        	
        } 
            
            
if(!request.getParameter("publisher").isEmpty()){
	
	
	isNotEmpty[6] = 1 ;


if(isNotEmpty[0] == 1 || isNotEmpty[1] == 1 || isNotEmpty[2] == 1 || isNotEmpty[3] == 1 || isNotEmpty[4] == 1 || isNotEmpty[5] == 1  ){
	
	
	statement = statement+" and "+  columnName[6]+"=?";
	
	
	
}

else {
	
	statement = "select * from games where "+  columnName[6]+"=?";
	
}          	

} 
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            PreparedStatement ps=con.prepareStatement(statement);
            int count = 1;
            for(int x = 0; x<7 ; x++){
            	
            	
            	if(isNotEmpty[x] == 1){
            		ps.setString(count,selections[x]);
            		count++;
            		
            	}
            	
                  	
            	
            }
            
            
            
            
            
            
        
        ResultSet rs=ps.executeQuery();
            
            
            
            while (rs.next()) {
                al = new ArrayList<String>();
               
 
//                out.println(rs.getString(1));
//                out.println(rs.getString(2));
//                out.println(rs.getString(3));
//                out.println(rs.getString(4));
                al.add(rs.getString(1));
                al.add(rs.getString(2));
                al.add(rs.getString(3));
                al.add(rs.getString(4));
                gameInt = rs.getInt(5);
                al.add(rs.getString(6));
                al.add(rs.getString(7));
                al.add(rs.getString(8));
                al.add(rs.getString(9));
                al.add(rs.getString(10));
                al.add(rs.getString(11));
                al.add(rs.getString(12));
                
                gameList.add(al);
                
            }
            
            request.setAttribute("gameList", gameList);
            request.setAttribute("gameInt", gameInt);
            RequestDispatcher view = request.getRequestDispatcher("/SearchView.jsp");
            view.forward(request, response);
   
            
                  
            
            
            
            conn.close();
            System.out.println("Disconnected!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}