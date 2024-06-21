package thrillio;

import java.util.List;

import thrillio.constants.KidFriendlyStatus;
import thrillio.constants.UserType;
import thrillio.controllers.BookmarkController;
import thrillio.entities.Bookmark;
import thrillio.entities.User;
import thrillio.partner.Shareable;


public class View {
	public static void bookmark(User user, List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + " is bookmarking");
		for (List<Bookmark> bookmarkList: bookmarks) {
			int typeOffset = (int) (Math.random() * bookmarks.size());
			int bookmarkOffset = (int) (Math.random() * bookmarkList.size());

			Bookmark bookmark = bookmarks.get(typeOffset).get(bookmarkOffset);

			BookmarkController.getInstance().saveUserBookmark(user, bookmark);

			System.out.println(bookmark);

		}
	}

	public static void browse(User user, List<List<Bookmark>> bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items");
		int bookmarkCount = 0;
		for (List<Bookmark> bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
//				Bookmarking !!
//				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkedDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New item bookmarked: " + bookmark);
					}
//				}

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

	//				mark as kid friendly
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatusString().equals(KidFriendlyStatus.UKNOWN)) {
						String kidFriendlyStatusDecision = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatusDecision.equals(KidFriendlyStatus.UKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatusDecision, bookmark);
							
						}
					}
//					Sharing logic
					if (bookmark.getKidFriendlyStatusString().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if(isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
						
						
					}
					
				}

			}
		}
	}

//	TODO: below methods simulate user input. In future, after completion of the I/O module, user input will be supported from the console
	private static boolean getShareDecision() {
		return Math.random() < 0.5;
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		double randomVal = Math.random();
		return randomVal < 1 / 3 ? KidFriendlyStatus.APPROVED
				: (randomVal >= 1 / 3 && randomVal < 2 / 3) ? KidFriendlyStatus.REJECTED : KidFriendlyStatus.UKNOWN;
	}

	private static boolean getBookmarkedDecision(Bookmark bookmark) {
		return Math.random() < 0.5;
	}

}
