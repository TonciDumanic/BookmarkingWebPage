package hr.dumanic.tonci.bwpa.controlers;

import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.User;
import hr.dumanic.tonci.bwpa.managers.BookmarkManager;

public class BookmarkControler {
//xcyxc
	private static BookmarkControler instance = new BookmarkControler();
	
	private void BookmarkControler() {
		
	}
	
	public static BookmarkControler getInstance() {
		return instance;
	}

	public void saveUsersBookmark(User user, Bookmark bookmark) {
		
		BookmarkManager.getInstance().saveUsersBookmark(user,bookmark);
	}
}
