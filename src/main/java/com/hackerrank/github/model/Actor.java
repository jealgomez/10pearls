package com.hackerrank.github.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Actor {
	@Id
	@Column
	private Long id;
	@Column
	private String login;
	@Column(name = "avatar")
	private String avatar_url;

	public Actor() {
	}

	public Actor(Long id, String login, String avatar) {
		this.id = id;
		this.login = login;
		this.avatar_url = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the avatar_url
	 */
	public String getAvatar_url() {
		return avatar_url;
	}

	/**
	 * @param avatar_url the avatar_url to set
	 */
	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	@Override
	public String toString() {
		return "Actor [id=" + id + ", login=" + login + ", avatar_url=" + avatar_url + "]";
	}

}
