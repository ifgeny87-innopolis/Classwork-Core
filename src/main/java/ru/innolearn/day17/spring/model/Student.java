package ru.innolearn.day17.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created in project Inno-Classroom-Work in 08.01.17
 */
//@JsonAutoDetect
public class Student implements Serializable
{
	String name;
	int age;

	public Student(String n, int a)
	{
		name = n;
		age = a;
	}

	@JsonProperty("name")
	public String getName()
	{
		return name;
	}

	@JsonProperty("year")
	public int getAge()
	{
		return age;
	}
}
