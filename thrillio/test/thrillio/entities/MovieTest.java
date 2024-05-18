package thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import thrillio.constants.MovieGenre;
import thrillio.managers.BookmarkManager;

public class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test 1 - Check if title has porn and adult words
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
				8.5);
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertTrue("The movie is Kid friendly", isKidFriendlyEligible);

//		Test 2 - check if genre has porn or adult words
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane - adult version", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
				8.5);
		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("The movie is not Kid friendly", isKidFriendlyEligible);
	}

}
