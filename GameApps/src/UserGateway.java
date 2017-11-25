import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import com.mysql.jdbc.PreparedStatement;

//ROW DATA GATEWAY PATTERN FOR USER




public class UserGateway {
	
	
	
	private static final Connection String = null;






	public UserGateway() {
		
	}
	
	public UserGateway(String  username) {
		this.username = username;
	}
	
	
	
	
	
	
	private int userID;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String credit_card_type;
	private String credit_card_number;
	private String credit_card_cvv;
	private String credit_card_expiry;
	private Date last_login;
	private String type;
	
	
	
	
	
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCredit_card_type() {
		return credit_card_type;
	}

	public void setCredit_card_type(String credit_card_type) {
		this.credit_card_type = credit_card_type;
	}

	public String getCredit_card_number() {
		return credit_card_number;
	}

	public void setCredit_card_number(String credit_card_number) {
		this.credit_card_number = credit_card_number;
	}

	public String getCredit_card_cvv() {
		return credit_card_cvv;
	}

	public void setCredit_card_cvv(String credit_card_cvv) {
		this.credit_card_cvv = credit_card_cvv;
	}

	public String getCredit_card_expiry() {
		return credit_card_expiry;
	}

	public void setCredit_card_expiry(String credit_card_expiry) {
		this.credit_card_expiry = credit_card_expiry;
	}

	public String getLast_login() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(last_login);
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
	public String type() {
		return  type;
	}

	public void  type(String  type) {
		this. type =  type;
	}
	
	

	
	public synchronized static UserGateway findByUsername(String name) throws ClassNotFoundException  {
		try {
			String url = "jdbc:mysql://localhost/soen387";
			String username1 = "o_mercie";
			String password1 = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username1,password1); 	
			
			
			
			String statement = "SELECT `username`, `password`, `firstname`, `lastname`, 'email', 'address1', 'address2', 'city', state', 'zip, 'coutry', "
					+ "'credit_card_type', 'credit_card_number', 'credit_card_cvv', 'credit_card_expiry', 'last_login', 'type'  FROM `users` where `username`=?";
			java.sql.PreparedStatement dbStatement = con.prepareStatement(statement);
			dbStatement.setString(1, name);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String email = rs.getString("email");
				String address1 = rs.getString("address1");
				String address2 = rs.getString("address2");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String zip = rs.getString("zip");
				String country = rs.getString("country");
				String credit_card_type = rs.getString("credit_card_type");
				String credit_card_number = rs.getString("credit_card_number");
				String credit_card_cvv = rs.getString("credit_card_cvv");
				String credit_card_expiry = rs.getString("credit_card_expiry");
				Date last_login = rs.getDate("last_login");
				String type = rs.getString("type");
							
				
				
				UserGateway User = new UserGateway(username);
				User.password = password;
				User.firstname = firstname;
				User.lastname = lastname;
				User.email = email;
				User.address1 = address1;
				User.address2 = address2;
				User.city = city;
				User.state = state;
				User.zip = zip;
				User.country = country;
				User.credit_card_type = credit_card_type;
				User.credit_card_number = credit_card_number;
				User.credit_card_cvv = credit_card_cvv;
				User.credit_card_expiry = credit_card_expiry;
				User.last_login = last_login;
				User.type = type;
				
				return User;
			}
			
			
		} catch (SQLException e) {
			// We don't want any types which use the StudentGateway
			// to be coupled to java.sql.SQLException
			// So instead, we throw a custom StudentGatewayException 
			
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	


