package com.legend.QuizGame.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "categories")
public class Categories {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "content is required!")
	@Size(min = 50, max = 200, message = "content must be between 50 and 200 characters")
	private String name;
	
	@NotEmpty(message = "description is required!")
	@Size(min = 50, max = 500, message = "description must be between 50 and 200 characters")
	private String description;
	


	@OneToMany(mappedBy="categories", fetch = FetchType.LAZY)
	    private List<Questions> questions;
	
	public Categories () {
		
		
	}
	
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}
}
