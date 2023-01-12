package hr.dumanic.tonci.bwpa.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hr.dumanic.tonci.bwpa.constants.BookGenre;
import hr.dumanic.tonci.bwpa.managers.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		
		//Test 1:  ART genre -> True	
		Book book = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String [] {"Henry David Thoreau"},BookGenre.ART,4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertTrue("The ART genre should return True",isKidFriendlyEligible);
		
		//Test 2: PHILOSOPHY genre -> False
		 book = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String [] {"Henry David Thoreau"},BookGenre.PHILOSOPHY,4.3);
		 isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse("The PHILOSOPHY should return False",isKidFriendlyEligible);
		
		
		
		//Test 3: SELF_HELP genre -> False
		 book = BookmarkManager.getInstance().createBook(4000,"Walden",1854,"Wilder Publications",new String [] {"Henry David Thoreau"},BookGenre.SELF_HELP,4.3);
		 isKidFriendlyEligible = book.isKidFriendlyEligible();

		 assertFalse("The SELF_HELP should return False",isKidFriendlyEligible);
		
		
	}

}
