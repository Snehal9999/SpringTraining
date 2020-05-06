package com.springMorissonDemo.conferencedemo.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Speakers {

	@Override
	public String toString() {
		return "Speakers [speaker_id=" + speaker_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", title=" + title + ", company=" + company + ", speaker_bio=" + speaker_bio + 
				 "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name = "speaker_id")
	private Long speaker_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "speaker_bio")
	private String speaker_bio;
	

	 @Lob
	 @Type(type="org.hibernate.type.BinaryType") 
	 private byte[] speaker_photo;
	 
	
	
	public List<Sessions> getSessions() {
		return sessions;
	}
	public void setSessions(List<Sessions> sessions) {
		this.sessions = sessions;
	}

	@ManyToMany(mappedBy = "speakers")
	@JsonIgnore
	private List<Sessions> sessions;

	public Speakers()
	{
		
	}
	public Long getSpeaker_id() {
		return speaker_id;
	}

	public void setSpeaker_id(Long speaker_id) {
		this.speaker_id = speaker_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSpeaker_bio() {
		return speaker_bio;
	}

	public void setSpeaker_bio(String speaker_bio) {
		this.speaker_bio = speaker_bio;
	}

	

}
