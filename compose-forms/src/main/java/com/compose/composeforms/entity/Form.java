package com.compose.composeforms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "form")
public class Form {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "deployed")
	private boolean deployed;

//	@JsonBackReference(value = "form-component")
	@OneToMany(mappedBy = "form", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<Component> components;

	public Form() {
		super();
	}

	public Form(String title, String description, boolean deployed) {
		super();
		this.title = title;
		this.description = description;
		this.deployed = deployed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeployed() {
		return deployed;
	}

	public void setDeployed(boolean deployed) {
		this.deployed = deployed;
	}

	public List<Component> getComponents() {
		return components;
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", title=" + title + ", description=" + description + ", deployed=" + deployed
				+ ", components=" + components + "]";
	}

	

}
