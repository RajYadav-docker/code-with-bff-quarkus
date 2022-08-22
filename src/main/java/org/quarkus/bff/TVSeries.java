package org.quarkus.bff;

import java.net.URL;
import java.util.Set;

public class TVSeries {
	
	private Long id;
	private String name;
	private URL url;
	private String Summary;
	private String language;
	private Set<String> genres;
	private URL officialSite;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public URL getUrl() {
		return url;
	}
	public void setUrl(URL url) {
		this.url = url;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Set<String> getGenres() {
		return genres;
	}
	public void setGenres(Set<String> genres) {
		this.genres = genres;
	}
	public URL getOfficialSite() {
		return officialSite;
	}
	public void setOfficialSite(URL officialSite) {
		this.officialSite = officialSite;
	}
	
	
	

}
