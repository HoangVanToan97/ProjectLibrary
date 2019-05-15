package vn.hust.security.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.hust.security.repository.UserRepository;

@Service(value = "preauthorizeUser")
public class PreauthorizeUser {
	@Autowired
	private UserRepository userRepository;
	
	public boolean authorize(String id) {
		try {
			if(userRepository.findByAuthId(id).getUsername().isEmpty()) {
				return false;
			}else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
