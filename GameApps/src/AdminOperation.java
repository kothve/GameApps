import java.util.ArrayList;

public class AdminOperation {
	
	public static void updateGames(String game_name, String console, int players, String genre, String year, String developer, String publisher, String price, String discount, int quantity, String description) throws ClassNotFoundException{
		
		
		GameGateway game = new GameGateway();
		
		game.setGame_name(game_name);
		game.setConsole(console);
		game.setPlayers(players);
		game.setGenre(genre);
		game.setRelease_date(year);
		game.setDeveloper(developer);
		game.setPublisher(publisher);
		game.setPrice(price);
		game.setDiscount(discount);
		game.setQuantity(quantity);
		game.setGame_description(description);
		
		
		
		
		
		game.update();
		
		
		
		
		
		
		
	}
	
public static void insertGames(String game_name, String console, int players, String genre, String year, String developer, String publisher, String price, String discount, int quantity, String description) throws ClassNotFoundException{
		
		
		GameGateway game = new GameGateway();
		game.setGame_name(game_name);
		game.setConsole(console);
		game.setPlayers(players);
		game.setGenre(genre);
		game.setRelease_date(year);
		game.setDeveloper(developer);
		game.setPublisher(publisher);
		game.setPrice(price);
		game.setDiscount(discount);
		game.setQuantity(quantity);
		game.setGame_description(description);
		
		
		
		
		
		game.insert();
		
		
		
		
		
		
		
	}


	
	
	
	
	

}
