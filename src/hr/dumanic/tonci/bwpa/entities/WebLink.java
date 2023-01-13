package hr.dumanic.tonci.bwpa.entities;

import org.apache.commons.lang3.StringUtils;

import hr.dumanic.tonci.bwpa.partner.Sherable;

public class WebLink extends Bookmark implements Sherable{
	public String url;
	public String host;
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}
	@Override
	public boolean isKidFriendlyEligible() {
		if(url.contains("porn") || getTitle().contains("porn") || host.contains("adult")) {
			return false;
			
		}
			
		return true;
	}
	
	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("<item>");
			builder.append("<type>WebLink</type>");
			builder.append("<title>").append(getTitle()).append("</title>");
			builder.append("<url>").append(url).append("</url>");
			builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		
		return builder.toString();
	}
	
}
