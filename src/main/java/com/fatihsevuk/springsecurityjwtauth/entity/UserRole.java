package com.fatihsevuk.springsecurityjwtauth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "user_role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole implements Serializable {

	private static final long serialVersionUID = 33454454L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long userRoleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne(fetch = FetchType.EAGER)
	private Role role;


	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public User getUser() {
		return user;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

}