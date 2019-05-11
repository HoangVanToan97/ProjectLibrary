package vn.hust.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.hust.security.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	Optional<UserEntity> findById(Long id);
	
	UserEntity findByUsername(String username);
	
	List<UserEntity> findAll();

}