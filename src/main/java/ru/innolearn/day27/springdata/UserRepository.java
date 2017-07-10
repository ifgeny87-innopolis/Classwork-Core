package ru.innolearn.day27.springdata;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created in project Inno-Classroom-Work on 19.01.17
 */
@Component
public interface UserRepository extends CrudRepository<User, Integer>
{
	List<User> findByName(String name);
	List<User> findByNameAndAge(String name, int age);
}
