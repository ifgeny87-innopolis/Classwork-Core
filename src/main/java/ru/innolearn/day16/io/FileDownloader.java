package ru.innolearn.day16.io;

import org.springframework.stereotype.Component;

/**
 * Created in project Inno-Classroom-Work in 26.12.2016
 */
@Component
public class FileDownloader implements Downloader {
	public String download(String path) {
		System.out.println("+++FILE DOWNLOADED");

		return "CoNtEnT";
	}
}
