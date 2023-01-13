package hr.dumanic.tonci.bwpa;

import hr.dumanic.tonci.bwpa.constants.KidFriendlyStatus;
import hr.dumanic.tonci.bwpa.constants.UserType;
/*Testing Git*/
import hr.dumanic.tonci.bwpa.controlers.BookmarkControler;
import hr.dumanic.tonci.bwpa.entities.Bookmark;
import hr.dumanic.tonci.bwpa.entities.User;

public class View {
	
//	public static void bookmark(User user, Bookmark[][] bookmarks) {
//
//		System.out.println("Boomarking user: " + user);
//
//		for(int i=0;i<DataStore.USER_BOOKAMRK_LIMIT;i++) {
//			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
//			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);;
//
//			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
//
//			BookmarkControler.getInstance().saveUsersBookmark(user,bookmark);
//
//			System.out.print(bookmark);
//		}
//	}

	public static void browse(User user, Bookmark[][] bookmarks) {
		
		System.out.println("\nUser " + user.getEmail()+  " is browsing items!");
		
		int bookmarkCount = 0;
		
		for(Bookmark[] bookmarkList:bookmarks) {
			for(Bookmark bookmark:bookmarkList) {
				//Bookmarking!!
				if(bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if(isBookmarked) {
						
						BookmarkControler.getInstance().saveUsersBookmark(user,bookmark);

						System.out.print("New item bookmaked: " + bookmark);

						
						bookmarkCount++;
					}
				}
				
				if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().endsWith(UserType.CHIEF_EDITOR)) {
					
					if(bookmark.isKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						
						String kidFriendlyStatus = getKidFriendlyStatusDecission(bookmark);
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							bookmark.setKidFriendlyStatus(kidFriendlyStatus);
							System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", " + bookmark);
						}
					}
					
				}
			}
		}
		
		
		
		
		/*for(int i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++) {
			int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
			int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);;

			Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

			BookmarkControler.getInstance().saveUsersBookmark(user,bookmark);

			System.out.print(bookmark);
		}*/
		
	}

	private static String getKidFriendlyStatusDecission(Bookmark bookmark) {
		double randomVal = Math.random();
	     
	    return randomVal < 0.4 ? KidFriendlyStatus.APPROVED :
	        (randomVal >= 0.4 && randomVal < 0.8) ? KidFriendlyStatus.REJECTED :
	            KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true: false;
	}

}
