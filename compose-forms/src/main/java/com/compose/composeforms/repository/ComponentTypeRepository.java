package com.compose.composeforms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compose.composeforms.entity.ComponentType;

@Repository
public interface ComponentTypeRepository extends JpaRepository<ComponentType, Long> {
	Optional<ComponentType> findByType(String type);
}
