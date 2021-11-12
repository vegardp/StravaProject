//package es.deusto.ingenieria.sd.strava.client.gui;
//
//import java.text.DateFormat;
//import java.text.NumberFormat;
//import java.util.List;
//import java.util.Locale;
//
//import es.deusto.ingenieria.sd.strava.server.data.dto.ArticleDTO;
//import es.deusto.ingenieria.sd.strava.server.data.dto.CategoryDTO;
//import es.deusto.ingenieria.sd.strava.client.controller.BidController;
//
////This clase simulates the GUI of the Bid use case
//public class BidWindow {
//	
//	private BidController controller;
//	
//	//This attributes are user for formatting currencies and dates
//	private static NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance(Locale.getDefault());
//	private static DateFormat DATE_FORMATTER = DateFormat.getDateTimeInstance();
//	
//	public BidWindow(BidController bid) {
//		this.controller = bid;
//	}
//
//	public List<CategoryDTO> getCategories() {
//	
//		
//		List<CategoryDTO> categories = this.controller.getCategories();
//		
//		for (CategoryDTO category : categories) {
//		
//		}
//		
//		return categories;
//	}
//
//	public List<ArticleDTO> getArticles(String category) { 		
//		
//		List<ArticleDTO> articles = this.controller.getArticles(category);
//			
//		return articles;		
//	}
//	
//	
//	public void makeBid(long token, ArticleDTO article) {		
//		CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance(Locale.getDefault());
//		
//		//Bid amount is 1 euro greather than the actual price of the article
//		float bid = article.getActualPrice()+1; 
//
//		boolean bidResult = this.controller.makeBid(token, article.getNumber(), bid);
//		
//	}
//}