package com.compose.composeforms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compose.composeforms.entity.Form;
import com.compose.composeforms.entity.FormComplete;
import com.compose.composeforms.entity.Users;

@Repository
public interface FormCompleteRepository extends JpaRepository<FormComplete, Long>{

	List<FormComplete> findByFormAndUser(Form form, Users user);



}
