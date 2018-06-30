package br.com.intelipost.user.details.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.intelipost.user.details.document.User;

public interface UserRepository extends MongoRepository<User, Integer> {
	
	User findByUsername(String username);

	List<User> findByUsernameNotIn(String username);
}
