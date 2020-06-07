package com.compose.composeforms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compose.composeforms.entity.Form;
import com.compose.composeforms.entity.FormComplete;
import com.compose.composeforms.message.request.FormSubmit;
import com.compose.composeforms.message.response.SubmittedElement;
import com.compose.composeforms.message.response.SubmittedForm;
import com.compose.composeforms.service.FormCompleteService;

@RestController
@RequestMapping("/api")
public class FormCompleteController {

	@Autowired
	private FormCompleteService formCompleteService;

	@CrossOrigin("http://localhost:3000")
	@PostMapping("/forms/submit")
	public ResponseEntity<String> submitData(@RequestBody FormSubmit formSubmit) {
		if (formCompleteService.alreadySubmited(formSubmit.getUser_id(), formSubmit.getForm_id())) {
			return new ResponseEntity<String>("You have already submited this form", HttpStatus.BAD_REQUEST);
		}
		formCompleteService.saveFormComplete(formSubmit);
		return ResponseEntity.ok().body("Data submited successfully!");
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/forms/submittedForms")
	public List<SubmittedForm> findAll() {
		return formCompleteService.findAll();
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/forms/submittedForms/{form_id}")
	public List<SubmittedElement> findById(@PathVariable("form_id") Long form_id) {

		return formCompleteService.findById(form_id);
	}

}
