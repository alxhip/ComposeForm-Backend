package com.compose.composeforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compose.composeforms.entity.Form;



@Repository
public interface FormRepository extends JpaRepository<Form, Long> {

	

	
}
