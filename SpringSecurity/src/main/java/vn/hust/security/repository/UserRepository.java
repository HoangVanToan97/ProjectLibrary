package vn.hust.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.hust.security.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findById(Long id); 
	
	UserEntity findByUsername(String username);
	
	List<UserEntity> findAll();
	
	UserEntity findByAuthId(String authId);
	
	@Query("from UserEntity u where u.id = ?1")
	UserEntity checkUser(Long id);
}