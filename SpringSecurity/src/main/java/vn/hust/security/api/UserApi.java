package vn.hust.security.api;

import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hust.security.entity.UserEntity;
import vn.hust.security.service.UserService;

@RestController
@RequestMapping("api/v1/web")
public class UserApi {
	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public void addUser(@RequestBody UserEntity userEntity) {
		UserEntity userEntity2 = new UserEntity(userEntity.getUsername(),
				BCrypt.hashpw(userEntity.getPassword(), BCrypt.gensalt()), "ROLE_USER", 1,
				DigestUtils.md5Hex(userEntity.getUsername()).substring(19, 32));
		userService.addUser(userEntity2);
	}

	@PostMapping("/search")
	public Optional<UserEntity> searchById(@RequestBody UserEntity userEntity) {
		return userService.searchById(userEntity.getId());
	}

	@GetMapping("/admin/listUser")
	public List<UserEntity> getList() {
		return userService.getList();
	}

}
