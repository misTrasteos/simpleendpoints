package org.acme.randomString;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringResponseVO {

	private String randomString = null;
	private LocalDateTime now = null;
	
	public RandomStringResponseVO() {
		this.randomString = RandomStringUtils.randomAlphabetic(10);
		this.now = LocalDateTime.now();
	}
	
	public String getRandomString() {
		return randomString;
	}
	public void setRandomString(String randomString) {
		this.randomString = randomString;
	}
	public LocalDateTime getNow() {
		return now;
	}
	public void setNow(LocalDateTime now) {
		this.now = now;
	}	

}//RandomStringResponseVO