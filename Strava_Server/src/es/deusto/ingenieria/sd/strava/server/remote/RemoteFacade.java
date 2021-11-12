package es.deusto.ingenieria.sd.strava.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import es.deusto.ingenieria.sd.strava.server.data.domain.Article;
//import es.deusto.ingenieria.sd.strava.server.data.domain.Category;
import es.deusto.ingenieria.sd.strava.server.data.domain.User;
//import es.deusto.ingenieria.sd.strava.server.data.dto.ArticleAssembler;
//import es.deusto.ingenieria.sd.strava.server.data.dto.ArticleDTO;
//import es.deusto.ingenieria.sd.strava.server.data.dto.CategoryAssembler;
//import es.deusto.ingenieria.sd.strava.server.data.dto.CategoryDTO;
//import es.deusto.ingenieria.sd.strava.server.services.BidAppService;
import es.deusto.ingenieria.sd.strava.server.services.LoginAppService;

public class RemoteFacade extends UnicastRemoteObject implements IRemoteFacade {	
	private static final long serialVersionUID = 1L;

	//Data structure for manage Server State
	public Map<Long, User> serverState = new HashMap<>();

	public RemoteFacade() throws RemoteException {
		super();		
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFacade login: " + email + " / " + password);
		
		//Perform login() using LoginAppService
		User user = LoginAppService.getInstance().login(email, password);
		
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout: " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not not logged in!");
		}
	}
	
//	@Override
//	public List<CategoryDTO> getCategories() throws RemoteException {
//		
//		//Get Categories using BidAppService
//		List<Category> categories = BidAppService.getInstance().getCategories();
//		
//		if (categories != null) {
//			//Convert domain object to DTO
//			return CategoryAssembler.getInstance().categoryToDTO(categories);
//		} else {
//			throw new RemoteException("getCategories() fails!");
//		}
//	}
//
//	@Override
//	public List<ArticleDTO> getArticles(String category) throws RemoteException {
//
//		//Get Articles using BidAppService
//		List<Article> articles = BidAppService.getInstance().getArticles(category);
//		
//		if (articles != null) {
//			//Convert domain object to DTO
//			return ArticleAssembler.getInstance().articleToDTO(articles);
//		} else {
//			throw new RemoteException("getArticles() of a category fails!");
//		}
//	}
//	
//	@Override
//	public boolean makeBid(long token, int article, float amount) throws RemoteException {		
//		
//		if (this.serverState.containsKey(token)) {						
//			//Make the bid using Bid Application Service
//			if (BidAppService.getInstance().makeBid(this.serverState.get(token), article, amount)) {
//				return true;
//			} else {
//				throw new RemoteException("makeBid() fails!");
//			}
//		} else {
//			throw new RemoteException("To place a bid you must first log in");
//		}
//	}
}