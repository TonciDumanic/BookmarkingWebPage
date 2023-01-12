package hr.dumanic.tonci.bwpa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hr.dumanic.tonci.bwpa.constants.MovieGenre;
import hr.dumanic.tonci.bwpa.managers.BookmarkManager;

class MovieTest {

	@Test
	void testIsKidFriendlyEligible() {
		//Test 1: Movie genre is TELEVISION -> true
		Movie movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.TELEVISION,8.5);

		assertTrue(movie.isKidFriendlyEligible());
		
		//Test 2: Movie genre is HORROR -> false
		movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.HORROR,8.5);

		assertFalse(movie.isKidFriendlyEligible());
		
		//Test 3: Movie genre is THRILLERS -> false
		movie = BookmarkManager.getInstance().createMovie(3000,"Citizen Kane","",1941,new String[] {"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"},MovieGenre.THRILLERS,8.5);

		assertFalse(movie.isKidFriendlyEligible());
		
	}

}
