package com.shivam.Hibernate_JDBC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_details")
public class InstructorDetail {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="youtube_channel")
	private String youtube_link;
	
	@Column(name="hobby")
	private String hobby;
	
	public InstructorDetail() {

	}

	public InstructorDetail(String youtube_link, String hobby) {
		super();
		this.youtube_link = youtube_link;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutube_link() {
		return youtube_link;
	}

	public void setYoutube_link(String youtube_link) {
		this.youtube_link = youtube_link;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtube_link=" + youtube_link + ", hobby=" + hobby + "]";
	}
	
	
	
}
