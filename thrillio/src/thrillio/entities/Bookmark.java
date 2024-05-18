package thrillio.entities;

import thrillio.constants.KidFriendlyStatus;

public abstract class Bookmark {
	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileUrl=" + profileUrl + "]";
	}

	private long id;
	private String title;
	private String profileUrl;
	private String kidFriendlyStatusString = KidFriendlyStatus.UKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	
	public abstract boolean isKidFriendlyEligible();

	public String getKidFriendlyStatusString() {
		return kidFriendlyStatusString;
	}

	public void setKidFriendlyStatusString(String kidFriendlyStatusString) {
		this.kidFriendlyStatusString = kidFriendlyStatusString;
	}

	public User getKidFriendlyMarkedBy() {
		return kidFriendlyMarkedBy;
	}

	public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
		this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
	}

	public User getSharedBy() {
		return sharedBy;
	}

	public void setSharedBy(User sharedBy) {
		this.sharedBy = sharedBy;
	}

}
