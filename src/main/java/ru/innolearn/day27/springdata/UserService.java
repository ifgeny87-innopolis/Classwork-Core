package ru.innolearn.day27.springdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created in project Inno-Classroom-Work on 19.01.17
 */
public interface UserService  {
	Iterable<User> findAll();
	Iterable<User> findByName(String name);
	Iterable<User> findByNameAndAge(String name, int age);
}