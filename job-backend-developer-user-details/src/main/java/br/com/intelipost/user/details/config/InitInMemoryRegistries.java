package br.com.intelipost.user.details.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.intelipost.user.details.document.UserDetailsIntelipost;
import br.com.intelipost.user.details.repository.UserDetailIntelipostRepository;

@Component
public class InitInMemoryRegistries {

	@Autowired
	private UserDetailIntelipostRepository userDetailIntelipostRepository;
	
	@PostConstruct
	public void init() {
		List<UserDetailsIntelipost> details = userDetailIntelipostRepository.findAll();
		if (details.isEmpty()) {
			List<UserDetailsIntelipost> detailsUser = buildDefaultUsers();
			List<UserDetailsIntelipost> detailsUserSaved = userDetailIntelipostRepository.saveAll(detailsUser);
		}
	}

	private List<UserDetailsIntelipost> buildDefaultUsers() {
		UserDetailsIntelipost detailsIntelipost = new UserDetailsIntelipost();
		detailsIntelipost.setAddress("Rua Silva Bueno, 09");
		detailsIntelipost.setCity("São Paulo");
		detailsIntelipost.setFullName("Robson Vieira");
		detailsIntelipost.setNickName("Rob");
		detailsIntelipost.setUserId(1L);
		
		UserDetailsIntelipost detailsIntelipost2 = new UserDetailsIntelipost();
		detailsIntelipost2.setAddress("Avenida Marechal Teodoro, 1905");
		detailsIntelipost2.setCity("São Paulo");
		detailsIntelipost2.setFullName("Alisson Suzuki");
		detailsIntelipost2.setNickName("Japa");
		detailsIntelipost2.setUserId(2L);
		
		return Arrays.asList(detailsIntelipost, detailsIntelipost2);
	}
}
