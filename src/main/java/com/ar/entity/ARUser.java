package com.ar.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ARUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String name;

	private String mobile;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	@Column(name = "dob")
	private LocalDate dateOfBirth;
	
	private String role;

	@Column(name = "created_date", nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	private Timestamp updatedDate;

}
