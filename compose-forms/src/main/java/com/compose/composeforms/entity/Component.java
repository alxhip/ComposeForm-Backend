package com.compose.composeforms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "component")
public class Component {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "componentType_id")
	private ComponentType componentType;

	@JsonBackReference(value = "component-form")
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "form_id")
	private Form form;

	@JsonBackReference(value = "component-componentContent")
	@OneToMany(mappedBy = "component", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<ComponentContent> componentContent;

	@Column(name = "title")
	private String title;

	public Component() {
		super();
	}

	public Component(ComponentType componentType, Form form, String title) {
		super();
		this.componentType = componentType;
		this.form = form;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ComponentType getComponentType() {
		return componentType;
	}

	public void setComponentType(ComponentType componentType) {
		this.componentType = componentType;
	}

	public List<ComponentContent> getComponentContent() {
		return componentContent;
	}

	public void setComponentContent(List<ComponentContent> componentContent) {
		this.componentContent = componentContent;
	}

}
