package ru.innolearn.day14.hibernate.common;

/**
 * Model class for Stock
 */
public class Stock {

	private Integer id;
	private String code;
	private String name;

	public Stock() {
	}

	public Stock(String code, String name) {
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