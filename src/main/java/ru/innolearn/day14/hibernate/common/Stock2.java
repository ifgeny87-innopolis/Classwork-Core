package ru.innolearn.day14.hibernate.common;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;

/**
 * Model class for Stock with annotation
 */
@Entity
@Table(name = "stock")
public class Stock2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String code;

	private String name;

	public Stock2() {
	}

	public Stock2(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer stockId) {
		this.id = stockId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Id = " + id +
				"\t| Code = " + code +
				"\t| Name = " + name;
	}

	public String toString(String format) {
		return String.format(format, id, code, name);
	}
}