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

@Entity
@Table(name = "form_complete")
public class FormComplete {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

//	@JsonBackReference(value = "component-form")
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "form_id")
	private Form form;

//	@JsonBackReference(value = "componentType-component")
	@OneToMany(mappedBy = "formComplete", cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<ComponentComplete> componentComplete;

//	@JsonBackReference(value = "user-form")
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private Users user;

//	@Column(name="value")
//	private String value;
	public FormComplete() {
		super();
	}

	public FormComplete(Form form, Users user) {
		super();
		this.form = form;
		this.user = user;
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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<ComponentComplete> getComponentComplete() {
		return componentComplete;
	}

	public void setComponentComplete(List<ComponentComplete> componentComplete) {
		this.componentComplete = componentComplete;
	}

	@Override
	public String toString() {
		return "FormComplete [id=" + id + ", form=" + form + ", user=" + user + "]";
	}

}
