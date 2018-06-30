package br.com.intelipost.user.details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.intelipost.user.details.document.User;
import br.com.intelipost.user.details.repository.UserRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;


    public UsuarioDetailsServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }
	
	@Override
	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = new User();
		try {
			user = userRepository.findByUsername(username);
			
		} catch (Exception e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
		return user;
	}
}
