package thrillio.entities;

import thrillio.partner.Shareable;

public class WebLink extends Bookmark implements Shareable{

	
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>Weblink</type>");
			builder.append("<title>").append(this.getTitle()).append("</title>");
			builder.append("<url>").append(this.getUrl()).append("</url>");
			builder.append("<host>").append(this.getHost()).append("</host>");
			
		builder.append("</item>");
		
		return builder.toString();
	}

	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getProfileUrl()=" + getProfileUrl() + "]";
	}

}
