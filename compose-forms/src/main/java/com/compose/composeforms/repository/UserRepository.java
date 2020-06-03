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

//	Boolean existsByEmail(String email);

//	boolean existsByNipt(String nipt);

	Optional<Users> findById(Long id);

	@Transactional
	@Modifying
	@Query("update Users set password=?2 where id=?1")
	void updatePassword(Long id, String password);

//	@Transactional
//	@Modifying
//	@Query("from Users cli where supervisor_id=?1 and cli.active=true")
//	ArrayList<Users> getClientsBySupervisor (Long supervisor_id);

//	@Transactional
//	@Modifying
//	@Query("select cli from Users cli inner join cli.supervisor as supervisor inner join supervisor.supervisor as administrator inner join administrator.roles as role where administrator.id=?1 and cli.active=true")
//	ArrayList<Users> getClientsByAdministrator(Long administrator_id);
//
//	@Transactional
//	@Modifying
//	@Query("select cli from Users cli inner join cli.supervisor as supervisor where supervisor.id=?1 and cli.active=true")
//	ArrayList<Users> getClientsBySupplier(Long supervisor_id);
//
//	@Transactional
//	@Modifying
//	@Query("select cli from Users cli inner join cli.supervisor as agent left join agent.supervisor as administrator inner join cli.roles role where administrator.id=?1 or agent.id=?1 and cli.active=true and role.code='Client'")
//	ArrayList<Users> getClientsBySupervisor(Long supervisor_id);
//
//	@Transactional
//	@Modifying
//	@Query("select client from Users client inner join client.supervisor as administrator where administrator.id=?1")
//	ArrayList<Users> getSupplierByAdministrator(Long administrator_id);
//
//	@Transactional
//	@Modifying
//	@Query("select client from Users client where active= false")
//	ArrayList<Users> getInactiveClients();
//
//	@Transactional
//	@Modifying
//	@Query("update Users set active= true where id=?1")
//	ArrayList<Users> activateClient(Long clientId);
}