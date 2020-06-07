package com.compose.composeforms.message.response;

import java.util.Arrays;

public class SubmittedForm {
	private Long formId;
	private String formTitle;
	private String formDescription;
	private String username;
	private SubmittedElement[] submittedElements;

	public SubmittedForm() {
		super();
	}

	public SubmittedForm(Long formId, String formTitle, String formDescription, String username,
			SubmittedElement[] submittedElements) {
		super();
		this.formId = formId;
		this.formTitle = formTitle;
		this.formDescription = formDescription;
		this.username = username;
		this.submittedElements = submittedElements;
	}

	public Long getFormId() {
		return formId;
	}

	public void setFormId(Long formId) {
		this.formId = formId;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public String getFormDescription() {
		return formDescription;
	}

	public void setFormDescription(String formDescription) {
		this.formDescription = formDescription;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public SubmittedElement[] getSubmittedElements() {
		return submittedElements;
	}

	public void setSubmittedElements(SubmittedElement[] submittedElements) {
		this.submittedElements = submittedElements;
	}

	@Override
	public String toString() {
		return "SubmittedForm [formId=" + formId + ", formTitle=" + formTitle + ", formDescription=" + formDescription
				+ ", username=" + username + ", submittedElements=" + Arrays.toString(submittedElements) + "]";
	}

}
