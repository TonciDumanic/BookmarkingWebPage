package hr.dumanic.tonci.bwpa;

import java.util.ArrayList;
import java.util.List;

import hr.dumanic.tonci.bwpa.constants.BookGenre;
import hr.dumanic.tonci.bwpa.constants.Gender;
import hr.dumanic.tonci.bwpa.constants.MovieGenre;
import hr.dumanic.tonci.bwpa.constants.UserType;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.User;
import hr.dumanic.tonci.bwpa.entities.UserBookmark;
import hr.dumanic.tonci.bwpa.entities.WebLink;
import hr.dumanic.tonci.bwpa.managers.BookmarkManager;
import hr.dumanic.tonci.bwpa.managers.UserManager;
import hr.dumanic.tonci.bwpa.util.IOUtil;

public class DataStore {

	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	
	private static List<User> users= new ArrayList<>();
	private static List<List<Bookmark>> bookmarks = new  ArrayList<>();
	private static List<UserBookmark> userBookmarks = new ArrayList<>();
	
	private static void loadUsers() {
/*		users[0] = UserManager.getInstance().createUser(1000,"user0@semanticsquare.com","test","John","M",Gender.MALE,UserType.USER);
		users[1] = UserManager.getInstance().createUser(1001,"user1@semanticsquare.com","test","Sam","M",Gender.MALE,UserType.USER);
		users[2] = UserManager.getInstance().createUser(1002,"user2@semanticsquare.com","test","Anita","M",Gender.MALE,UserType.EDITOR);
		users[3] = UserManager.getInstance().createUser(1003,"user3@semanticsquare.com","test","Sara","M",Gender.FEMALE,UserType.EDITOR);
		users[4] = UserManager.getInstance().createUser(1004,"user4@semanticsquare.com","test","Dheeru","M",Gender.MALE,UserType.CHIEF_EDITOR);   
	*/
		List<String> data = new ArrayList<>();
		
		IOUtil.read(data, "User");
		
		for(String row: data) {
			String[] values = row.split("\t");
			
			int gender = Gender.MALE;
			if(values[5].equals("f")) {
				gender = Gender.FEMALE;
			} else if (values[5].equals("t")) {
				gender = Gender.OTHER;
			}
				
			User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
			users.add(user);
		}
	}
	

	private static void loadWebLinks() {
		
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "WebLink");
		List<Bookmark> bookmarkList = new ArrayList<>();
		
		for(String row: data) {
			String[] values = row.split("\t");
			
				
			Bookmark bookmark = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]);
			bookmarkList.add(bookmark);
			
			
		}
		
		bookmarks.add(bookmarkList);
	}
	
	private static void loadMovies() {
		
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "Movie");
		List<Bookmark> bookmarkList = new ArrayList<>();
		
		for(String row: data) {
			String[] values = row.split("\t");
		
			String[] cast =  values[3].split(",");
			String[] directors =  values[4].split(",");
			
			
					
			Bookmark bookmark = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1],"", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6]));
			bookmarkList.add(bookmark);

		}
		
		bookmarks.add(bookmarkList);
	}

	private static void loadBooks() {
		
		List<String> data =  new ArrayList<>();
		IOUtil.read(data, "Book");
		List<Bookmark> bookmarkList = new ArrayList<>();

		for(String row: data) {
			String[] values = row.split("\t");
		
			String[] authors =  values[4].split(",");
					
			Bookmark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
			bookmarkList.add(bookmark);

		}
		bookmarks.add(bookmarkList);
	}
	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}


	/**
	 * @return the users
	 */
	public static List<User> getUsers() {
		return users;
	}


	/**
	 * @return the bookmarks
	 */
	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}


	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}


	


	

	


	
}
