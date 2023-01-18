package hr.dumanic.tonci.bwpa.controlers;

import hr.dumanic.tonci.bwpa.constants.KidFriendlyStatus;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.User;
import hr.dumanic.tonci.bwpa.managers.BookmarkManager;

public class BookmarkControler {

	private static BookmarkControler instance = new BookmarkControler();
	
	private void BookmarkControler() {
		
	}
	
	public static BookmarkControler getInstance() {
		return instance;
	}

	public void saveUsersBookmark(User user, Bookmark bookmark) {
		
		BookmarkManager.getInstance().saveUsersBookmark(user,bookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyStatus,Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus,bookmark);
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user,bookmark); 		
	}
}
