package com.compose.composeforms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compose.composeforms.entity.Component;
import com.compose.composeforms.entity.ComponentContent;
import com.compose.composeforms.entity.Form;
import com.compose.composeforms.message.request.ElementCreate;
import com.compose.composeforms.message.request.FormCreate;
import com.compose.composeforms.repository.ComponentContentRepository;
import com.compose.composeforms.repository.ComponentRepository;
import com.compose.composeforms.repository.ComponentTypeRepository;
import com.compose.composeforms.repository.FormRepository;

@Service
public class FormServiceImpl implements FormService {

	@Autowired
	private FormRepository formRepository;

	@Autowired
	private ComponentRepository componentRepository;

	@Autowired
	private ComponentTypeRepository componentTypeRepository;

	@Autowired
	private ComponentContentRepository componentContentRepository;

	@Override
	@Transactional
	public void saveForm(FormCreate formCreate) {
		Form form = new Form(formCreate.getTitle(), formCreate.getDescription(), false);
		formRepository.save(form);
		for (ElementCreate element : formCreate.getElements()) {
			Component component = new Component(
					componentTypeRepository.findByType(element.getType()).get(), form,
					element.getTitle());
			componentRepository.save(component);
			if (element.getOptions() != null) {

				for (String option : element.getOptions()) {
					componentContentRepository.save(new ComponentContent(component, option, false));
				}
			}
		}
	}

	@Override
	@Transactional
	public List<Form> findAll() {
		return formRepository.findAll();
	}

	@Override
	public Form findById(Long form_id) {
		return formRepository.findById(form_id).get();
	}

	@Override
	public void deployForm(Long formId) {
		Form form=formRepository.findById(formId).get();
		form.setDeployed(true);
		formRepository.save(form);
		
	}

}
