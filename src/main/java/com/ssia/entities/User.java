package com.ssia.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private EncryptionAlgorithm algorithm;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Authority> authorities;
	
}
