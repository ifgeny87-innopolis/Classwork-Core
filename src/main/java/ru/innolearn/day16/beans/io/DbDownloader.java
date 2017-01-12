package ru.innolearn.day16.beans.io;

/**
 * Created in project Inno-Classroom-Work in 26.12.2016
 */
public class DbDownloader implements Downloader {
	public String download(String path) {
		System.out.println("+++DATABASE DOWNLOADED");

		return "CoNtEnT";
	}
}
