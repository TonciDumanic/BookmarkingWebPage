package hr.dumanic.tonci.bwpa.dao;

import java.util.List;

import hr.dumanic.tonci.bwpa.DataStore;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.UserBookmark;

public class BookmarkDao {

	public List<List<Bookmark>> getUser() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
	}
}
