package hr.dumanic.tonci.bwpa.managers;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import hr.dumanic.tonci.bwpa.DataStore;
import hr.dumanic.tonci.bwpa.constants.BookGenre;
import hr.dumanic.tonci.bwpa.constants.KidFriendlyStatus;
import hr.dumanic.tonci.bwpa.constants.MovieGenre;
import hr.dumanic.tonci.bwpa.dao.BookmarkDao;
import hr.dumanic.tonci.bwpa.entities.Book;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.Movie;
import hr.dumanic.tonci.bwpa.entities.User;
import hr.dumanic.tonci.bwpa.entities.UserBookmark;
import hr.dumanic.tonci.bwpa.entities.WebLink;
import hr.dumanic.tonci.bwpa.util.HttpConnect;
import hr.dumanic.tonci.bwpa.util.IOUtil;

public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();
	
	private static BookmarkDao bookmarkDao = new BookmarkDao();
	
	public static BookmarkManager getInstance() {
		
		return instance;
	}
	
	public Movie createMovie( long id,String title,	String profile, int releaseYear, String[] cast, String[] directors, MovieGenre genre, double imdbRating) {
		
		Movie movie = new Movie();

		movie.setId(id);
		movie.setTitle(title);
		movie.setProfile(profile);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}
	
	public Book createBook( long id,String title,int publicationYear,String publisher,String[] authors,BookGenre genre,double amazonRating) {
		
		Book book = new Book();

		book.setId(id);
		book.setTitle(title);
		book.setGenre(genre);
		book.setAuthors(authors);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAmazonRating(amazonRating);
		
		return book;
	}
	
	public WebLink createWebLink( long id,String title, String url, String host) {
		
		WebLink webLink = new WebLink();

		webLink.setId(id);
		webLink.setTitle(title);
		webLink.setHost(host);
		webLink.setUrl(url);
		
		return webLink;
	}
	
	public List<List<Bookmark>> getBookmarks() {
	
		return DataStore.getBookmarks();
	}

	public void saveUsersBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
	
		if (bookmark instanceof WebLink) {
			try {				
				String url = ((WebLink)bookmark).getUrl();
				if (!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(((WebLink)bookmark).getUrl());
					if (webpage != null) {
						IOUtil.write(webpage, bookmark.getId());
					}
				}				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		bookmarkDao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", marked by " + user.getEmail() + ", " + bookmark);
	}

	public void share(User user, Bookmark bookmark) {

		bookmark.setSharedBy(user);
		
		if(bookmark instanceof Book) {
			System.out.println(((Book) bookmark).getItemData());
		} 
		else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink) bookmark).getItemData());
		}
	}
}
