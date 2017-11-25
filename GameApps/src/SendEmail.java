
// File Name SendEmail.java
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SendEmail extends HttpServlet {
	
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();
String to = request.getParameter("userEmail");
String subject = "New password";
String message = "Here is your new password";
String user = "gameapps387@gmail.com";
String pass = "concordia1234";
String username=request.getParameter("userName");




if(UserEmailValidation.EmailUservalidate(username, to)){
	
	
	request.setAttribute("ResetPassword", "successful"); 
	
	SendMail.send(to,subject, message, user, pass);
	
	
	
	addTempPassword.addPassword(username);
	
	RequestDispatcher view = request.getRequestDispatcher("/Login.jsp");
	 view.forward(request, response);
	

}





}}