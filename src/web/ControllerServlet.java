package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.Imetier;
import metier.Shop;
import metier.User;
import metier.Work;

public class ControllerServlet extends HttpServlet {
	private Imetier metier;
	
	@Override
	public void init() throws ServletException {
		metier=new Work();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUser;
		ShopModel model=new ShopModel();
		request.setAttribute("model", model);
		model.setUser(new User(request.getParameter("eml"),request.getParameter("pwd")));
		idUser=metier.signIn(model.getUser());
		HttpSession session=request.getSession();
		
		String action=request.getParameter("action");
		//Sign in + page main//
		if(action!=null)
		{
			if(action.equals("Sign in"))
			{
		if(idUser!=0)
		{
			List<Shop> shops=metier.displayShops(idUser);
			model.setShops(shops);
			model.getUser().setIdu(idUser);
			session.setAttribute("id_user", idUser);
			
			
			
			this.getServletContext().getRequestDispatcher("/MainView.jsp").forward(request, response);
			
		}
		else{
			
			this.getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
			
		}
		
			}
		// My preferred shop list//
			else if(action.equals("prefer"))
			{
				List<Shop> preferredshops=metier.displayPreferredShops((int)session.getAttribute("id_user"));
				
				model.setPreferredshops(preferredshops);
				
				this.getServletContext().getRequestDispatcher("/PreferredShopView.jsp").forward(request, response);
				
			}
		     
			else if(action.equals("prefer"))
			{
				List<Shop> preferredshops=metier.displayPreferredShops((int)session.getAttribute("id_user"));
				
				model.setPreferredshops(preferredshops);
				
				this.getServletContext().getRequestDispatcher("/PreferredShopView.jsp").forward(request, response);
				
			}
		// like //
			else if(action.equals("like"))
			{
				User u =new User();
				Shop s=new Shop();
				u.setIdu((int)session.getAttribute("id_user"));
				s.setIds(Integer.parseInt(request.getParameter("idsp")));
				
			    metier.likeShop(u,s);
				List<Shop> shops=metier.displayShops((int)session.getAttribute("id_user"));
				
				model.setShops(shops);
				
				this.getServletContext().getRequestDispatcher("/MainView.jsp").forward(request, response);
				
			}
		// Dislike //
					else if(action.equals("dislike"))
					{
						User u =new User();
						Shop s=new Shop();
						u.setIdu((int)session.getAttribute("id_user"));
						s.setIds(Integer.parseInt(request.getParameter("idps")));
						
					    metier.dislikeShop(u, s);
					    List<Shop> preferredshops=metier.displayPreferredShops((int)session.getAttribute("id_user"));
						
						model.setPreferredshops(preferredshops);
						
						this.getServletContext().getRequestDispatcher("/PreferredShopView.jsp").forward(request, response);
						
					}
			// home //
					else if(action.equals("home"))
					{
						List<Shop> shops=metier.displayShops((int)session.getAttribute("id_user"));
						model.setShops(shops);
						
						this.getServletContext().getRequestDispatcher("/MainView.jsp").forward(request, response);
						
					}
			// Sign up//
					else if(action.equals("Sign up"))
						
					{
				 String email=request.getParameter("upeml");
				 String password=request.getParameter("uppwd");
				 String confirmPassword=request.getParameter("cfpwd");
			
		if(email!="" && password!="" && password.equals(confirmPassword))
		{
			User u=new User(email,password);
			metier.signUp(u);
			this.getServletContext().getRequestDispatcher("/LoginView.jsp").forward(request, response);
			
			
			
			
			
		}
		
		
		}
			
				
		}
		
	}

}
