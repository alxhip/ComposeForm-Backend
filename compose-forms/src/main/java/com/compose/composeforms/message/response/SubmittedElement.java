package com.compose.composeforms.message.response;

public class SubmittedElement {
	private String componentTitle;
	private String value;

	public SubmittedElement() {
		super();
	}

	public SubmittedElement(String componentTitle, String value) {
		super();
		this.componentTitle = componentTitle;
		this.value = value;
	}

	public String getComponentTitle() {
		return componentTitle;
	}

	public void setComponentTitle(String componentTitle) {
		this.componentTitle = componentTitle;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SubmittedElement [componentTitle=" + componentTitle + ", value=" + value + "]";
	}
	
	

}
