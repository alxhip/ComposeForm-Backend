package com.compose.composeforms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compose.composeforms.entity.Component;
import com.compose.composeforms.entity.ComponentComplete;
import com.compose.composeforms.entity.Form;
import com.compose.composeforms.entity.FormComplete;
import com.compose.composeforms.entity.Users;
import com.compose.composeforms.message.request.ElementComplete;
import com.compose.composeforms.message.request.FormSubmit;
import com.compose.composeforms.message.response.SubmittedElement;
import com.compose.composeforms.message.response.SubmittedForm;
import com.compose.composeforms.repository.ComponentCompleteRepository;
import com.compose.composeforms.repository.ComponentRepository;
import com.compose.composeforms.repository.FormCompleteRepository;
import com.compose.composeforms.repository.FormRepository;
import com.compose.composeforms.repository.UserRepository;

@Service
public class FormCompleteService {

	@Autowired
	FormCompleteRepository formCompleteRepository;

	@Autowired
	UserRepository userRespository;

	@Autowired
	ComponentCompleteRepository componentCompleteRepository;

	@Autowired
	ComponentRepository componentRepository;

	@Autowired
	FormRepository formRepository;

	@Autowired
	UserRepository userRepository;

	@Transactional
	public void saveFormComplete(FormSubmit formSubmit) {
		Users user = userRespository.findById(formSubmit.getUser_id()).get();
		Form form = formRepository.findById(formSubmit.getForm_id()).get();
		FormComplete formComplete = formCompleteRepository.save(new FormComplete(form, user));
		Component component;
		for (ElementComplete element : formSubmit.getElements()) {
			component = componentRepository.findById(element.getComponent_id()).get();
			componentCompleteRepository.save(new ComponentComplete(formComplete, component, element.getValue()));
		}

	}

	public List<SubmittedForm> findAll() {
		List<SubmittedForm> submittedForms = new ArrayList<SubmittedForm>();
		List<FormComplete> formComplete = formCompleteRepository.findAll();
		Long id;
		String title;
		String description;
		String username;
		for (FormComplete form : formComplete) {
			id = form.getId();
			title = form.getForm().getTitle();
			description = form.getForm().getDescription();
			username = form.getUser().getUsername();
			submittedForms.add(new SubmittedForm(id, title, description, username, null));
		}
		return submittedForms;
	}

	public boolean alreadySubmited(long user_id, long form_id) {
		Users user = userRepository.findById(user_id).get();
		Form form = formRepository.findById(form_id).get();
		List<FormComplete> formComplete = formCompleteRepository.findByFormAndUser(form, user);
		return (formComplete.size() > 0);
	}

	public List<SubmittedElement> findById(Long form_id) {
		FormComplete formComplete = formCompleteRepository.findById(form_id).get();
		List<SubmittedElement> submittedElements = new ArrayList<SubmittedElement>();
		for (ComponentComplete component : formComplete.getComponentComplete()) {
			submittedElements.add(new SubmittedElement(component.getComponent().getTitle(), component.getValue()));
		}
		return submittedElements;
	}
}
