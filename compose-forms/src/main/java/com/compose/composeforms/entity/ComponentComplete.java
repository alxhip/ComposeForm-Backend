package com.compose.composeforms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "componentComplete")
public class ComponentComplete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "formComplete_id")
	private FormComplete formComplete;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "component_id")
	private Component component;

	@Column(name = "value")
	private String value;

	public ComponentComplete() {
		super();
	}

	public ComponentComplete(FormComplete formComplete, Component component, String value) {
		super();
		this.formComplete = formComplete;
		this.component = component;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FormComplete getFormComplete() {
		return formComplete;
	}

	public void setFormComplete(FormComplete formComplete) {
		this.formComplete = formComplete;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ComponentComplete [id=" + id + ", formComplete=" + formComplete + ", component=" + component
				+ ", value=" + value + "]";
	}
	
	
}
