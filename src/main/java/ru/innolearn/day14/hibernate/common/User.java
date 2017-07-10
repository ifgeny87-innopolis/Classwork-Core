package ru.innolearn.day14.hibernate.common;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created in project Inno-Classroom-Work in 16.01.17
 */
@Entity
@Table(name = "user")
public class User
{
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  FIELDS
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	private Integer age;

	@ManyToOne(fetch = FetchType.LAZY)
	private Room room;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tech2user",
			joinColumns = @JoinColumn(name = "tech_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<Tech> techList;

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  GETTERS
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	public int getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public Integer getAge()
	{
		return age;
	}

	public Room getRoom()
	{
		return room;
	}

	public List<Tech> getTech()
	{
		return techList;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  OVERRIDE
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	@Override
	public String toString()
	{
		return String.format("%3d | %15s | %4d | %5s | %s", id, name, age,
				room == null ? "---" : room.getNumber(),
				String.join(", ",
						techList.stream()
								.map(Tech::getName)
								.collect(Collectors.toList())));
	}
}
