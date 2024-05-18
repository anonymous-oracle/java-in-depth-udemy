package thrillio;

import java.util.ArrayList;
import java.util.List;

import thrillio.constants.BookGenre;
import thrillio.constants.Gender;
import thrillio.constants.MovieGenre;
import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.entities.UserBookmark;
import thrillio.managers.BookmarkManager;
import thrillio.managers.UserManager;
import thrillio.util.IOUtil;

public class DataStore {
//	public static final int USER_BOOKMARK_LIMIT = 5;
//	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
//	public static final int BOOKMARK_TYPES_COUNT = 3;
//	public static final int TOTAL_USER_COUNT = 5;

	private static List<User> users = new ArrayList<>();

	public static List<User> getUsers() {
		return users;
	}

	private static List<List<Bookmark>> bookmarks = new ArrayList<>();

	public static List<List<Bookmark>> getBookmarks() {
		return bookmarks;
	}

	private static List<UserBookmark> userBookmarks = new ArrayList<>();
	private static int bookmarkIndex;

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {
//		String[] data = new String[TOTAL_USER_COUNT];
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "User.txt");
		for (String row : data) {
			String[] values = row.split("\t");

			int gender = Gender.MALE;
			if (values[5].equals("f")) {
				gender = Gender.FEMALE;
			} else if (values[5].equals("t")) {
				gender = Gender.TRANSGENDER;
			}

			User user = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3],
					values[4], gender, values[6]);
			users.add(user);
		}
	}

	private static void loadWebLinks() {
//		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];

		List<String> data = new ArrayList<>();
		IOUtil.read(data, "WebLink.txt");
		List<Bookmark> bookmarkList = new ArrayList<>();

		for (String row : data) {
			String[] values = row.split("\t");
			Bookmark bookmark = BookmarkManager.getInstance().createWeblink(Long.parseLong(values[0]), values[1],
					values[2], values[3]/* , values[4] */);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);

	}

	private static void loadMovies() {
//		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "Movie.txt");
		List<Bookmark> bookmarkList = new ArrayList<>();
		for (String row : data) {
			String[] values = row.split("\t");
			String[] cast = values[3].split(",");
			String[] directors = values[4].split(",");
			Bookmark bookmark = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "",
					Integer.parseInt(values[2]), cast, directors, values[5],
					Double.parseDouble(values[6])/* , values[7] */);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}

	private static void loadBooks() {
//		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
		List<String> data = new ArrayList<>();
		IOUtil.read(data, "Book.txt");
		List<Bookmark> bookmarkList = new ArrayList<>();
		for (String row : data) {
			String[] values = row.split("\t");
			String[] authors = values[4].split(",");
			Bookmark bookmark = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1],
					Integer.parseInt(values[2]), values[3], authors, values[5],
					Double.parseDouble(values[6])/* , values[7] */);
			bookmarkList.add(bookmark);
		}
		bookmarks.add(bookmarkList);
	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks.add(userBookmark);
	}
}
