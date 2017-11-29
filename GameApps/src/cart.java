
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author 
 */
public class cart {
    ArrayList cartItems;
    public cart(){
     cartItems = new ArrayList<String>();
      
    }
    public ArrayList getCartItems(){
        return cartItems;
    }
    public void addToCart(ArrayList<String> name){
        cartItems.add(name);
        
    }
     
    public void deleteFromCart(String game_name){
        cartItems.remove(0);
        cartItems.remove(1);
    }
}