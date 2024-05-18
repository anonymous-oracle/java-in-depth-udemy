package thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import thrillio.constants.BookGenre;
import thrillio.managers.BookManager;
import thrillio.managers.BookmarkManager;

public class BookTest {

	@Test
	public void testIsKidFriendlyEligible() {

//		test 1 - assert kid friendly to be false if adult/porn words are present in the title or genres of the book
		Book book = BookManager.getInstance().createBook(4000, "adult Walden", 1854, "Wilder Publications",
				new String[] { "Henry David", "Thoreau" }, BookGenre.PHILOSOPHY, 4.3);

		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse("The title or the genre should contain the words porn/adult", isKidFriendlyEligible);
// test 2 - assert kid friendly to be true if adult/porn words are not present in the title or genres of the book
		book = BookManager.getInstance().createBook(4000, "Walden", 1854, "Wilder Publications",
				new String[] { "Henry David", "Thoreau" }, BookGenre.PHILOSOPHY, 4.3);

		isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertTrue("The title or the genre should not contain the words porn/adult", isKidFriendlyEligible);
	}

}
