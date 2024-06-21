package thrillio;


import java.util.List;

import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.managers.BookmarkManager;
import thrillio.managers.UserManager;

public class Launch {
	private static List<User> users;
	private static List<List<Bookmark>> bookmarks;
	public static void main(String[] args) {
		loadData();
		start();
		
		
	}
	
	private static void start() {
//		System.out.println("\n2. Bookmarking...");
		for (User user : users) {
		 View.browse(user, bookmarks);	
		}
	}

	private static void printBookMarkData() {
		for(List<Bookmark> bookmarkList: bookmarks) {
			System.out.println();
			for(Bookmark bookmark: bookmarkList) {
				System.out.println(bookmark);
			}
		}
		
	}

	private static void printUserData() {
		for(User user: users) {
			System.out.println(user);
		}
		
	}

	private static void loadData() {
		System.out.println("1. Loading data...");
		DataStore.loadData();
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
//		System.out.println("Printing User Data...");
//		printUserData();
//		printBookMarkData();
	}
}
