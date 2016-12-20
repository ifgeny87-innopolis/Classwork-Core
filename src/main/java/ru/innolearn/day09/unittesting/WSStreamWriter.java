package ru.innolearn.day09.unittesting;

public class WSStreamWriter implements StreamWriter {
	@Override
	public int write(String obj) {
	    /*тут какая-то сложная логика, так что выбросим исключение*/
		throw new RuntimeException("Not implemented yet");
	}
}
