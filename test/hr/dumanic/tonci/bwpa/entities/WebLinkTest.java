package hr.dumanic.tonci.bwpa.entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hr.dumanic.tonci.bwpa.managers.BookmarkManager;

class WebLinkTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1 porn in url -- false
		WebLink webLink  = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");

		boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For porn in url isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		
		//Test 2 porn in title -- false
		
		webLink  = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2 porn ","http://www.javaworld.com/article/2072759/core-java/taming---part-2.html","http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For porn in title isKidFriendlyEligible()  must return false",isKidFriendlyEligible);
		
		//Test 3 adult in host -- false
		webLink  = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2  ","http://www.javaworld.com/article/2072759/core-java/taming-a--part-2.html","http://www.javaworldadult.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertFalse("For adult in hot isKidFriendlyEligible() must return false",isKidFriendlyEligible);
		

		//Test 4 adult in url but not host -- true
		
		webLink  = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2  ","http://www.javaworld.com/article/2072759/core-javaadult/taming-a-part-2.html","http://www.javaworld.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in url but not host isKidFriendlyEligible() must return true",isKidFriendlyEligible);
		
	
		//Test 5 adult in title only -- true
		

		webLink  = BookmarkManager.getInstance().createWebLink(2000,"Taming adult, Part 2  ","http://www.javaworld.com/article/2072759/core-java/taming-a--part-2.html","http://www.javaworl.com");

		isKidFriendlyEligible = webLink.isKidFriendlyEligible();
		
		assertTrue("For adult in title only isKidFriendlyEligible() must return true",isKidFriendlyEligible);
	
		
	}

}
