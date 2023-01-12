package hr.dumanic.tonci.bwpa.entities;

import java.util.Arrays;

import hr.dumanic.tonci.bwpa.constants.BookGenre;

public class Book extends Bookmark{

	private int publicationYear;
	private String publisher;
	private String[] authors;
	private String genre;
	private double amazonRating;
	
	/**
	 * @return the publicationYear
	 */
	public int getPublicationYear() {
		return publicationYear;
	}
	/**
	 * @param publicationYear the publicationYear to set
	 */
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the authors
	 */
	public String[] getAuthors() {
		return authors;
	}
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the amazonRating
	 */
	public double getAmazonRating() {
		return amazonRating;
	}
	/**
	 * @param amazonRating the amazonRating to set
	 */
	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}
	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publisher=" + publisher + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}
	@Override
	public boolean isKidFriendlyEligible() {
		
		if(genre.equals(BookGenre.SELF_HELP) || genre.equals(BookGenre.PHILOSOPHY) ) {
			return false;
		}
		return true;
	}

	
}
