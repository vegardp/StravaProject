//package es.deusto.ingenieria.sd.strava.client.controller;
//
//import java.rmi.RemoteException;
//import java.util.List;
//
//import es.deusto.ingenieria.sd.strava.server.data.dto.ArticleDTO;
//import es.deusto.ingenieria.sd.strava.server.data.dto.CategoryDTO;
//import es.deusto.ingenieria.sd.strava.client.remote.ServiceLocator;
//
////This class implements Controller pattern.
//public class BidController {
//	
//	//Reference to the Service Locator
//	private ServiceLocator serviceLocator;
//	
//	public BidController(ServiceLocator serviceLocator) {
//		this.serviceLocator = serviceLocator; 
//	}
//
//	public List<CategoryDTO> getCategories() {
//		try {
//			return this.serviceLocator.getService().getCategories();
//		} catch (RemoteException e) {
//			System.out.println("# Error getting all categories: " + e);
//			return null;
//		}
//	}
//
//	public List<ArticleDTO> getArticles(String category) {
//		try {
//			return this.serviceLocator.getService().getArticles(category);
//		} catch (RemoteException e) {
//			System.out.println("# Error getting articles of a category: " + e);
//			return null;
//		}
//	}
//
//	public boolean makeBid(long token, int article, float bid) {
//		try {
//			return this.serviceLocator.getService().makeBid(token, article, bid);
//		} catch (RemoteException e) {
//			System.out.println("# Error making a bid: " + e);
//			return false;
//		}
//	}
//	
//
//}