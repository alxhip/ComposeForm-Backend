package com.compose.composeforms.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.compose.composeforms.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Optional<Users> findByUsername(String username);

	Boolean existsByUsername(String username);

	Optional<Users> findById(Long id);

	@Transactional
	@Modifying
	@Query("update Users set password=?2 where id=?1")
	void updatePassword(Long id, String password);

}