package ru.innolearn.day16.io;

/**
 * Created in project Inno-Classroom-Work in 26.12.2016
 */
public interface Uploader {

	/**
	 *
	 * @param path
	 * @param content
	 * @return
	 */
	public boolean upload(String path, Object content);
}

