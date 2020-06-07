package com.compose.composeforms.message.request;

import java.util.Arrays;

public class FormCreate {
	private ElementCreate[] elements;
	private String title;
	private String description;

	public FormCreate() {
		super();
	}

	public ElementCreate[] getElements() {
		return elements;
	}

	public void setElements(ElementCreate[] elements) {
		this.elements = elements;
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

	@Override
	public String toString() {
		return "FormCreate [elements=" + Arrays.toString(elements) + ", title=" + title + ", description=" + description
				+ "]";
	}

	

}
