package hr.dumanic.tonci.bwpa.managers;
import hr.dumanic.tonci.bwpa.DataStore;
import hr.dumanic.tonci.bwpa.dao.BookmarkDao;
import hr.dumanic.tonci.bwpa.entities.Book;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.Movie;
import hr.dumanic.tonci.bwpa.entities.User;
import hr.dumanic.tonci.bwpa.entities.UserBookmark;
import hr.dumanic.tonci.bwpa.entities.WebLink;

public class BookmarkManager {

	private static BookmarkManager instance = new BookmarkManager();
	
	private static BookmarkDao bookmarkDao = new BookmarkDao();
	
	public static BookmarkManager getInstance() {
		
		return instance;
	}
	
	public Movie createMovie( long id,String title,	String profile, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating) {
		
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
	
	public Book createBook( long id,String title,int publicationYear,String publisher,String[] authors,String genre,double amazonRating) {
		
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
	
	public Bookmark[][] getBookmarks() {
	
		return DataStore.getBookmarks();
	}

	public void saveUsersBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		
		bookmarkDao.saveUserBookmark(userBookmark);
	}
}
