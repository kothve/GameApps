import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameGateway {
	
	
	
	
	
	private int gameID; //
	private String game_name;
	private String game_description ="";
	private String console ="";
	private int players = 0; 
	private String coop ="";
	private String genre ="";
	private String release_date ="";
	private String developer ="";
	private String publisher ="";
	private String price ="";
	private String discount ="0";
	private int quantity = 0;
	
	
	public GameGateway(){	
		this.discount = "0";
	}
	
	public GameGateway(String name){
		
					
		
	}
	
	
	
	
	
	public String getGame_name() {
		return game_name;
	}
	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}
	public String getGame_description() {
		return game_description;
	}
	public void setGame_description(String game_description) {
		this.game_description = game_description;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public int getPlayers() {
		return players;
	}
	public void setPlayers(int players) {
		this.players = players;
	}
	public String getCoop() {
		return coop;
	}
	public void setCoop(String coop) {
		this.coop = coop;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getGameID() {
		return gameID;
	}
	
	
	//domain logic methods
	
	
	public boolean onSales(){
		
		
		
		return !discount.equals("0");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public synchronized static GameGateway findByGameName(String gameName) throws ClassNotFoundException  {
		try {
			String url = "jdbc:mysql://localhost/soen387";
			String username1 = "o_mercie";
			String password1 = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username1,password1); 	
			
			
			
			String statement = "SELECT `games_id`, `game_name`, `game_description`, `console`, `num_players`, `coop`, `genre`, `release_date`, `developer`, `publisher`, `price`, "
					+ "`discount`, `quantity`  FROM `games` where `game_name`=?";
			java.sql.PreparedStatement dbStatement = con.prepareStatement(statement);
			dbStatement.setString(1, gameName);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int gameId = rs.getInt("gameID");
				String game_name = rs.getString("game_name");
				String game_description = rs.getString("game_description");
				String console = rs.getString("console");
				int num_players = rs.getInt("num_players");
				String coop = rs.getString("coop");
				String genre = rs.getString("genre");
				String release_date = rs.getString("release_date");
				String developer = rs.getString("developer");
				String publisher = rs.getString("publisher");
				String price = rs.getString("price");
				
				String discount = rs.getString("discount");
				if (rs.wasNull())
					discount = "0";
				int quantity = rs.getInt("quantity");
				
											
				
				GameGateway Game = new GameGateway(gameName);
				
				
				Game.game_description = game_description;
				Game.gameID = gameId;
				Game.console = console;
				Game.players = num_players;
				Game.coop = coop;
				Game.genre = genre;
				Game.release_date = release_date;
				Game.developer = developer;
				Game.publisher = publisher;
				Game.price = price;
				Game.discount = discount;
				Game.quantity = quantity;
				
				
				
				
				
				return Game;
				
			}
			
			
		} catch (SQLException e) {
			// We don`t want any types which use the StudentGateway
			// to be coupled to java.sql.SQLException
			// So instead, we throw a custom StudentGatewayException 
			
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	public synchronized void update() throws ClassNotFoundException {
		try {
			String url = "jdbc:mysql://localhost/soen387";
			String username1 = "o_mercie";
			String password1 = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username1,password1); 	
	
			String statement = "UPDATE `games` SET  `game_description`=?, `console`=?, `num_players`=?, `coop`=?, `genre`=?, `release_date`=?, `developer`=?, `publisher`=?, `price`=?, "
					+ "`discount`=?, `quantity`=? where `game_name`=?";
			
			
			java.sql.PreparedStatement dbStatement = con.prepareStatement(statement);
			dbStatement.setString(1, this.game_description);
			dbStatement.setString(2, this.console);
			dbStatement.setInt(3, this.players);
			dbStatement.setString(4, this.coop);
			dbStatement.setString(5, this.genre);
			dbStatement.setString(6, this.release_date);
			dbStatement.setString(7, this.developer);
			dbStatement.setString(8, this.publisher);
			dbStatement.setString(9, this.price);
			dbStatement.setString(10, this.discount);
			dbStatement.setInt(11, this.quantity);
			dbStatement.setString(12, this.game_name);
			
			dbStatement.executeUpdate();
			
			
			
			con.close();
			
		} catch (SQLException e) {
			// We don`t want any types which use the Active Record
			// to be coupled to java.sql.SQLException
			// So instead, we throw a custom ActiveRecordException 
			
		}
	}
	
	public synchronized void insert() throws ClassNotFoundException {
		try {
			String url = "jdbc:mysql://localhost/soen387";
			String username1 = "o_mercie";
			String password1 = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username1,password1); 	
	
			String statement = "INSERT INTO `games` (`game_name`, `game_description`, `console`, `num_players`, `coop`, `genre`, `release_date`, `developer`, `publisher`, `price`, "
					+ "`discount`, `quantity`) VALUES (?, ?, ?, ?,?,?,?,?,?,?,?,?)";
			
			
			java.sql.PreparedStatement dbStatement = con.prepareStatement(statement);
			
			dbStatement.setString(1, this.game_name);
			dbStatement.setString(2, this.game_description);
			dbStatement.setString(3, this.console);
			dbStatement.setInt(4, this.players);
			dbStatement.setString(5, this.coop);
			dbStatement.setString(6, this.genre);
			dbStatement.setString(7, this.release_date);
			dbStatement.setString(8, this.developer);
			dbStatement.setString(9, this.publisher);
			dbStatement.setString(10, this.price);
			dbStatement.setString(11, this.discount);
			dbStatement.setInt(12, this.quantity);
			
			
			
			
			
			dbStatement.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// We don`t want any types which use the Active Record
			// to be coupled to java.sql.SQLException
			// So instead, we throw a custom ActiveRecordException 
			
		}
	}
	
	
	
	
	public synchronized void delete() throws ClassNotFoundException {
		try {
			String url = "jdbc:mysql://localhost/soen387";
			String username1 = "o_mercie";
			String password1 = "odette";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection(url,username1,password1); 	
	
			String statement = "DELETE FROM `games` where `game_name`=?";
			
			
			java.sql.PreparedStatement dbStatement = con.prepareStatement(statement);
			
			dbStatement.setString(1, this.game_name);
			
			
			dbStatement.executeUpdate();
			
			
			
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			// We don`t want any types which use the Active Record
			// to be coupled to java.sql.SQLException
			// So instead, we throw a custom ActiveRecordException 
			
		}
	}
	
	
	
	
	
	
	
	
	
}
	
	


