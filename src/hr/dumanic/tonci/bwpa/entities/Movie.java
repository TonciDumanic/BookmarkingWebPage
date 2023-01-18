package hr.dumanic.tonci.bwpa.entities;

import java.util.Arrays;

import hr.dumanic.tonci.bwpa.constants.BookGenre;
import hr.dumanic.tonci.bwpa.constants.MovieGenre;

public class Movie extends Bookmark{
	
	private int releaseYear;
	private String[] cast;
	private String[] directors;
	private MovieGenre genre;
	private double imdbRating;
	
	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the cast
	 */
	public String[] getCast() {
		return cast;
	}
	/**
	 * @param cast the cast to set
	 */
	public void setCast(String[] cast) {
		this.cast = cast;
	}
	/**
	 * @return the directors
	 */
	public String[] getDirectors() {
		return directors;
	}
	/**
	 * @param directors the directors to set
	 */
	public void setDirectors(String[] directors) {
		this.directors = directors;
	}
	/**
	 * @return the genre
	 */
	public MovieGenre getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(MovieGenre genre) {
		this.genre = genre;
	}
	/**
	 * @return the imdbRating
	 */
	public double getImdbRating() {
		return imdbRating;
	}
	/**
	 * @param imdbRating the imdbRating to set
	 */
	public void setImdbRating(double imdbRating) {
		this.imdbRating = imdbRating;
	}
	@Override
	public String toString() {
		return "Movie [releaseYear=" + releaseYear + ", cast=" + Arrays.toString(cast) + ", directors="
				+ Arrays.toString(directors) + ", genre=" + genre + ", imdbRating=" + imdbRating + "]";
	}
	@Override
	public boolean isKidFriendlyEligible() {
		
		if(genre.equals(MovieGenre.HORROR) || genre.equals(MovieGenre.THRILLERS)) {
			return false;
		}
		
		return true;
	}
	
	
	

}
