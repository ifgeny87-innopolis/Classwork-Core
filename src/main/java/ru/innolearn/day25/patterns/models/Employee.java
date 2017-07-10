package ru.innolearn.day25.patterns.models;

/**
 * Created in project Inno-Classroom-Work in 17.01.17
 */
abstract class Employee
{
	private String name;
	private String phone;
	private String email;

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  CONSTRUCTOR
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

	public Employee(String name, String phone, String email)
	{
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>
	//  ACTIONS
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~>

}
