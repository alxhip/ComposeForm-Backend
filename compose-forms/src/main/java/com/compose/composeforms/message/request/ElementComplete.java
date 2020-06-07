package com.compose.composeforms.message.request;

public class ElementComplete {
	private long component_id;
	private String value;

	public ElementComplete() {
		super();
	}

	public long getComponent_id() {
		return component_id;
	}

	public void setComponent_id(long component_id) {
		this.component_id = component_id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
