package com.compose.composeforms.message.request;

import java.util.Arrays;

public class ElementCreate {
	private String type;
	private String title;
	private String[] options;
	
	public ElementCreate() {
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Element [type=" + type + ", title=" + title + ", options=" + Arrays.toString(options) + "]";
	}

}
