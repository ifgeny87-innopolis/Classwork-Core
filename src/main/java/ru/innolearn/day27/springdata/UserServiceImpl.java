package ru.innolearn.day27.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created in project Inno-Classroom-Work on 19.01.17
 */
@Service("jpaUserService")
@Repository
@Transactional
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	public List<User> findByNameAndAge(String name, int age) {
		return userRepository.findByNameAndAge(name, age);
	}
}