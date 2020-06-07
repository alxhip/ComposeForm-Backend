package com.compose.composeforms.message.request;

public class FormSubmit {
	private long form_id;
	private long user_id;
	private ElementComplete[] elements;

	public FormSubmit() {
		super();
	}

	public long getForm_id() {
		return form_id;
	}

	public void setForm_id(long form_id) {
		this.form_id = form_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public ElementComplete[] getElements() {
		return elements;
	}

	public void setElements(ElementComplete[] elements) {
		this.elements = elements;
	}

}
