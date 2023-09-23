package sn.usher21.helloapp.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.usher21.helloapp.dtos.UserDto;
import sn.usher21.helloapp.models.User;
import sn.usher21.helloapp.repositories.UserRepository;

/**
 * UserController
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping()
	public List<UserDto> getUsers() {
		return this.userRepository.findAll().stream().map(UserDto::fromUser).toList();
	}

	@PostMapping()
	public User saveUser(@RequestBody User user) {
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		return this.userRepository.save(user);
	}

	@GetMapping("/{id}")
	public UserDto findUser(@PathVariable Long id) {
		User user = this.userRepository.findById(id).orElse(null);
		return UserDto.fromUser(user);
	}
}