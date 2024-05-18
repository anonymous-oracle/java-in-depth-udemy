package thrillio.dao;

import java.util.List;

import thrillio.DataStore;
import thrillio.entities.Bookmark;
import thrillio.entities.UserBookmark;

public class BookmarkDao {

	public List<List<Bookmark>> getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		
		DataStore.add(userBookmark);
	}
}
