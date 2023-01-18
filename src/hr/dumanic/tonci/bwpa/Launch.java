package hr.dumanic.tonci.bwpa;

import java.util.List;

import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.User;
import hr.dumanic.tonci.bwpa.managers.BookmarkManager;
import hr.dumanic.tonci.bwpa.managers.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;
	
	private static void loadData() {
		System.out.println("1. Loading data...");
		DataStore.loadData();
		
		System.out.println("2. Init users");
		users = UserManager.getInstance().getUsers();
		
		System.out.println("3. Init bookmarks");
		bookmarks = BookmarkManager.getInstance().getBookmarks();

		//System.out.println("4. Print user data");
		//printUserData();
		
//		System.out.println("5. Print bookmark data");
//		printBookmarkData();
		
	}
	
	private static void printBookmarkData() {
		
		
		for(List<Bookmark> bookmarkList:bookmarks) {
			for(Bookmark bookmark: bookmarkList) {
				System.out.println(bookmark);

				
			}
		}
	}

	private static void printUserData() {
		
		for(User user:users) {
			System.out.println(user);
		}
		
	}
	
	private static void start() {
		for (User user:users) {
			View.browse(user, bookmarks);
		}
		
	}

	public static void main(String[] args) {
		loadData();
		start();
	}

	
}
