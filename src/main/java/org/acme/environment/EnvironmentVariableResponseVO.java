package org.acme.environment;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;

public class EnvironmentVariableResponseVO {

	private String randomString = null;
	private LocalDateTime now = null;
	private String environmentVariable = null;
	
	public EnvironmentVariableResponseVO(String environmentVariableName) {
		this.randomString = RandomStringUtils.randomAlphabetic(10);
		this.now = LocalDateTime.now();
		this.environmentVariable = System.getenv(environmentVariableName);
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
	public String getEnvironmentVariable() {
		return environmentVariable;
	}
	public void setEnvironmentVariable(String environmentVariable) {
		this.environmentVariable = environmentVariable;
	}
}//RandomStringResponseVO