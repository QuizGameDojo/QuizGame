package com.legend.QuizGame.Models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "content is required!")
	@Size(min = 50, max = 200, message = "content must be between 50 and 200 characters")
	private String content;

	//ManyToOne
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categories_id")
	private Categories categories;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "results", joinColumns = @JoinColumn(name = "questions_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))

	private List<User> users;

	public Questions() {
	}
	
    @OneToOne(mappedBy="questions", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Help help;

	@OneToMany(mappedBy="questions", fetch = FetchType.LAZY)
	    private List<Answers> answers;
	

	// Getters and Setters
	

	public Categories getCategories() {
		return categories;
	}

	public Help getHelp() {
		return help;
	}

	public void setHelp(Help help) {
		this.help = help;
	}

	public List<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answers> answers) {
		this.answers = answers;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
