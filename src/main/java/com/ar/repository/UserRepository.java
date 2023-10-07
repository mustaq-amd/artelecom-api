package com.ar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ar.entity.ARUser;

@Repository
public interface UserRepository extends JpaRepository<ARUser, Long> {

	public Boolean existsByEmail(String email);

	Optional<ARUser> findByEmail(String email);
	
	public Boolean existsByMobile(String email);

	Optional<ARUser> findByMobile(String email);

}
