package hr.dumanic.tonci.bwpa;

/*Testing Git*/
import hr.dumanic.tonci.bwpa.controlers.BookmarkControler;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.User;

public class View {
	
	public static void bookmark(User user, Bookmark[][] bookmarks) {
		
		System.out.println("Boomarking user: " + user);
		
		for(int i=0;i<DataStore.USER_BOOKAMRK_LIMIT;i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);;
			
			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
			
			BookmarkControler.getInstance().saveUsersBookmark(user,bookmark);
			
			System.out.print(bookmark);
		}
	}

}
