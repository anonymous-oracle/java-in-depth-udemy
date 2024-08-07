package thrillio.entities;

public class UserBookmark {
	@Override
	public String toString() {
		return "UserBookmark [user=" + user + ", bookmark=" + bookmark + "]";
	}

	private User user;
	private Bookmark bookmark;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Bookmark getBookmark() {
		return bookmark;
	}

	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}

}
