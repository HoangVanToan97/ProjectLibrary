package vn.hust.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hust.security.repository.UserRepository;

@Service(value = "preauthorizeUser")
public class PreauthorizeUser {
	@Autowired
	private UserRepository userRepository;
	
	public boolean authorize(Long id) {
		if(userRepository.checkUser(id).getUsername().isEmpty() || userRepository.checkUser(id).getUsername() == null) {
			return false;
		}else {
			return true;
		}
	}

}
