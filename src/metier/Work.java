package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Work implements Imetier{

	@Override
	public void likeShop(User u,Shop s) {
		try{
			Connection cn=Myconnection.getMyconnection();
			PreparedStatement ps=cn.prepareStatement
					("insert into preferredshop(idu,ids) values(?,?)");
			ps.setInt(1, u.getIdu());
			ps.setInt(2, s.getIds());
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void dislikeShop(User u,Shop s) {
		try{
			Connection cn=Myconnection.getMyconnection();
			PreparedStatement ps=cn.prepareStatement
					("delete from preferredshop where idu=? and ids=?");
			ps.setInt(1, u.getIdu());
			ps.setInt(2, s.getIds());
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Shop> displayShops(int u) {
	    List<Shop> shops=new ArrayList<Shop>();
		try{
			Connection cn=Myconnection.getMyconnection();
			PreparedStatement ps=cn.prepareStatement
		("select ids,designation FROM shop where ids not in (SELECT ids from preferredshop where idu="+u+")");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Shop s=new Shop();
				s.setIds(rs.getInt("ids"));
				s.setDesignation(rs.getString("designation"));
			    shops.add(s);
			    
			}
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return shops;
	}

	@Override
	public List<Shop> displayPreferredShops(int u)
	{
		 List<Shop> shops=new ArrayList<Shop>();
			try{
				Connection cn=Myconnection.getMyconnection();
				PreparedStatement ps=cn.prepareStatement
						("select designation,shop.ids as 'idshop' from shop,preferredshop where shop.ids=preferredshop.ids and idu=?");
				ps.setInt(1,u);
				ResultSet rs=ps.executeQuery();
				while(rs.next()){
					Shop s=new Shop();
					s.setIds(rs.getInt("idshop"));
					s.setDesignation(rs.getString("designation"));
				    shops.add(s);
				    
				}
				ps.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return shops;
	}
	@Override
	public void signUp(User u) {
          
		try{
			Connection cn=Myconnection.getMyconnection();
			PreparedStatement ps=cn.prepareStatement
					("insert into user(email,password) values(?,?)");
			
			ps.setString(1,u.getEmail());
			ps.setString(2,u.getPassword());
			ps.executeUpdate();
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	@Override
	public int signIn(User u) {
		try{
			Connection cn=Myconnection.getMyconnection();
			PreparedStatement ps=cn.prepareStatement
					("select idu from user where email=? and password=?");
			ps.setString(1, u.getEmail());
			ps.setString(2, u.getPassword());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				 u.setIdu(rs.getInt("idu"));
				
			}
			else{
				
				u.setIdu(0);
			}
			
			ps.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return u.getIdu();
	}
	

}
