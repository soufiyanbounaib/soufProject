package metier;

import java.util.List;

public interface Imetier {
    
	public void likeShop(User u,Shop s);
	public void dislikeShop(User u,Shop s);
	public List<Shop> displayShops(int u);
	public List<Shop> displayPreferredShops(int u);
	public void signUp(User u);
	public int signIn(User u);
	
	
}
