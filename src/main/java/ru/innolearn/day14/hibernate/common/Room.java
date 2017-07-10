package ru.innolearn.day14.hibernate.common;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in project Inno-Classroom-Work in 16.01.17
 */
@Entity
@Table(name = "room")
public class Room
{
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  FIELDS
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private int number;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "room")
	@Fetch(value = FetchMode.JOIN)
	private List<User> users;

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  GETTERS
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	public int getId()
	{
		return id;
	}

	public int getNumber()
	{
		return number;
	}

	public List<User> getUsers()
	{
		return users;
	}


	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  OVERRIDE
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	@Override
	public String toString()
	{
		return String.format("%5d | %5d | %s",
				id, number,
				users == null ? "---" :
						String.join(", ", users
								.stream()
								.map(User::getName)
								.collect(Collectors.toList())));
	}
}
