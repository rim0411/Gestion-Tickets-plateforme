package com.user.dto;

public class CreateMainUser {
	private userprofile profile ;
	 private  credential credentials  ;
	public userprofile getProfile() {
		return profile;
	}
	public void setProfile(userprofile profile) {
		this.profile = profile;
	}
	public credential getCredentials() {
		return credentials;
	}
	public void setCredentials(credential credentials) {
		this.credentials = credentials;
	}

}
