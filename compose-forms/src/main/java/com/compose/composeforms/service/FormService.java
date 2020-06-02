package com.compose.composeforms.service;

import java.util.List;

import com.compose.composeforms.entity.Form;
import com.compose.composeforms.entity.FormCreate;

public interface FormService {

	void saveForm(FormCreate formCreate);

	public List<Form> findAll();

	Form findById(Long form_id);

}
