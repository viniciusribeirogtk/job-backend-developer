package br.com.intelipost.user.details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.intelipost.user.details.document.UserDetailsIntelipost;

public interface UserDetailIntelipostRepository extends MongoRepository<UserDetailsIntelipost, String>{

}
