package ru.innolearn.day16.beans.io;

/**
 * Created in project Inno-Classroom-Work in 26.12.2016
 */
public class DbUploader implements Uploader {
	public boolean upload(String path, Object content) {
		System.out.println("+++DATABASE UPLOADED");
		return true;
	}
}

