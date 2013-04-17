/**
 * 
 */
package com.rdd.engine;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;

import com.rdd.model.Site;

/**
 * @author Jesus Espinoza Hernandez
 * 
 */
@SuppressWarnings("serial")
public class SiteChecker implements Serializable {

	private int timeout;

	public SiteChecker() {
		this.timeout = 10;
	}

	public void checkSite(Site site) {
		try {
			URL u = new URL(site.getUrl());
			final HttpURLConnection conn = (HttpURLConnection) u.openConnection();
			conn.setRequestMethod("HEAD");
			conn.setConnectTimeout(this.timeout * 1000);
			conn.setReadTimeout(timeout * 1000);
			int responseCode = conn.getResponseCode();
			site.setReachable(200 <= responseCode && responseCode <= 399);
			site.setMessage(conn.getResponseMessage());
		} catch (IOException e) {
			System.out.print("Cannot reach site " + site.getUrl());
		}

	}

}
