package com.psp.javi2gar;

import java.io.File;

public class Department {

	private String name;
	private File urlFile;
	private File urlResFile;

	public Department(String name, String inFile, String outFile) {
		super();
		this.name = name;
		urlFile = new File(inFile + name + ".txt");
		urlResFile = new File(outFile + name + ".res");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getUrlFile() {
		return urlFile;
	}

	public void setUrlFile(File urlFile) {
		this.urlFile = urlFile;
	}

	public File getUrlResFile() {
		return urlResFile;
	}

	public void setUrlResFile(File urlResFile) {
		this.urlResFile = urlResFile;
	}

	@Override
	public String toString() {
		return "Department [name=" + name + ", urlFile=" + urlFile + "]";
	}

}
