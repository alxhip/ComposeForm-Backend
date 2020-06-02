package com.compose.composeforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compose.composeforms.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Long> {

}
