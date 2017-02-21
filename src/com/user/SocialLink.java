package com.user;

public class SocialLink {
	private int followerID;
	private int followeeID;

	public SocialLink(int followerID, int followeeID) {
		super();
		this.followerID = followerID;
		this.followeeID = followeeID;
	}

	public int getFollowerID() {
		return followerID;
	}

	public void setFollowerID(int followerID) {
		this.followerID = followerID;
	}

	public int getFolloweeID() {
		return followeeID;
	}

	public void setFolloweeID(int followeeID) {
		this.followeeID = followeeID;
	}

}
