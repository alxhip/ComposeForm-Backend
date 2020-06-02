package com.compose.composeforms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compose.composeforms.entity.Form;
import com.compose.composeforms.entity.FormCreate;
import com.compose.composeforms.service.FormService;

@RestController
@RequestMapping("/api")
public class FormsRestController {

	@Autowired
	private FormService formService;

	@CrossOrigin("http://localhost:3000")
	@PostMapping("/forms")
	public String saveForm(@RequestBody FormCreate formCreate) {
		formService.saveForm(formCreate);
		return formCreate.toString();
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/forms")
	public List<Form> findAll() {
		return formService.findAll();
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/forms/{form_id}")
	public Form findById(@PathVariable("form_id") Long form_id) {
		Form theForm = formService.findById(form_id);
		if (theForm == null) {
			throw new RuntimeException("job id not found - " + form_id);
		}
		return theForm;
	}

}
