/**
 * 
 */
package com.rdd.model;

/**
 * @author Jesus Espinoza Hernandez
 *
 */
public class Site {

	private String name;
	private String url;
	private boolean reachable;
	private String message;
	
	
	/**
	 * Getters and setters
	 */
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean isReachable() {
		return reachable;
	}
	
	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
