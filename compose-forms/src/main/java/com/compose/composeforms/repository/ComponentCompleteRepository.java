package com.compose.composeforms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compose.composeforms.entity.ComponentComplete;

@Repository
public interface ComponentCompleteRepository extends JpaRepository<ComponentComplete, Long>{

}
