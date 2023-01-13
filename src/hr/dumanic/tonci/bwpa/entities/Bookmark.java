package hr.dumanic.tonci.bwpa.entities;

import hr.dumanic.tonci.bwpa.constants.KidFriendlyStatus;

public abstract class Bookmark {
	private long id;
	private String title;
	private String profile;
	private String kidFriendlyStatus = KidFriendlyStatus.UNKNOWN;
	private User kidFriendlyMarkedBy;
	private User sharedBy;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profile=" + profile + "]";
	}
	
	public abstract boolean isKidFriendlyEligible();
	public String getKidFriendlyStatus() {
		return kidFriendlyStatus;
	}
	public void setKidFriendlyStatus(String kidFriendlyStatus) {
		this.kidFriendlyStatus = kidFriendlyStatus;
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
