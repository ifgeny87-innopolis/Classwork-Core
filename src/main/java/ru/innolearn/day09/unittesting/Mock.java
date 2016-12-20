package ru.innolearn.day09.unittesting;

/**
 * Created by marina on 15.12.2016.
 */
public class Mock {

	public String calc(int id) {
		String obj = this.streamReader.read(id);
		return calculateObj(obj);
	}

	public String calculateObj(String obj) {
		return "calculated " + obj;
	}

	//---------------------------------
	//  Getters & Setters
	//---------------------------------

	private StreamWriter streamWriter;
	private StreamReader streamReader;

	public StreamWriter getStreamWriter() {
		return streamWriter;
	}

	public void setStreamWriter(StreamWriter streamWriter) {
		this.streamWriter = streamWriter;
	}

	public StreamReader getStreamReader() {
		return streamReader;
	}

	public void setStreamReader(StreamReader streamReader) {
		this.streamReader = streamReader;
	}
}
