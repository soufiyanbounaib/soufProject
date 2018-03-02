package web;

import metier.User;
import metier.Shop;

import java.util.ArrayList;
import java.util.List;



public class ShopModel {
	
	private User user;
	private List<Shop> shops=new ArrayList<Shop>() ;
	private List<Shop> preferredshops=new ArrayList<Shop>() ;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Shop> getShops() {
		return shops;
	}
	public void setShops(List<Shop> shops) {
		this.shops = shops;
	}
	public List<Shop> getPreferredshops() {
		return preferredshops;
	}
	public void setPreferredshops(List<Shop> preferredshops) {
		this.preferredshops = preferredshops;
	}
	

}
