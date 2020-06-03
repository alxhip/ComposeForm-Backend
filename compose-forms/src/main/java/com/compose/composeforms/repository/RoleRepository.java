package com.compose.composeforms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compose.composeforms.entity.Role;
import com.compose.composeforms.entity.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
//	Optional<Role> findByName(RoleName roleName);

	Optional<Role> findByCode(RoleName roleName);
}