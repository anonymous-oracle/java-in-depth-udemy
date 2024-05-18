package thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import thrillio.partner.Shareable;

public class Book extends Bookmark implements Shareable{

	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amazonRating;


	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [id=" + this.getId() + ", title=" + this.getTitle() + ", publicationYear=" + publicationYear + ", publisher="
				+ publisher + ", authors=" + Arrays.toString(authors) + ", genre=" + genre + ", amazonRating="
				+ amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		return !(this.getTitle().contains("porn") || this.getTitle().contains("adult") || this.genre.contains("porn")
				|| this.genre.contains("adult"));
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>Book</type>");
			builder.append("<title>").append(this.getTitle()).append("</title>");
			builder.append("<authors>").append(StringUtils.join(this.authors, ",")).append("</authors>");
			builder.append("<publisher>").append(this.getPublisher()).append("</publisher>");
			builder.append("<publicationYear>").append(this.getPublicationYear()).append("</publicationYear>");
			builder.append("<genre>").append(this.getGenre()).append("</genre>");
			builder.append("<amazonRating>").append(this.getAmazonRating()).append("</amazonRating>");
		builder.append("</item>");
		
		return builder.toString();
		
	}

}
