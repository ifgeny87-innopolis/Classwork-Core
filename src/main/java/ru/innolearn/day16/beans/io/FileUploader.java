package ru.innolearn.day16.beans.io;

import org.springframework.stereotype.Component;

/**
 * Created in project Inno-Classroom-Work in 26.12.2016
 */
@Component
public class FileUploader implements Uploader {
	public boolean upload(String path, Object content) {
		System.out.println("+++FILE UPLOADED");
		return true;
	}
}

