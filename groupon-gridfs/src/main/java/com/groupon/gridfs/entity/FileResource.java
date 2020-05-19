package com.groupon.gridfs.entity;

public class FileResource {

	private String id;

	public FileResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileResource(String id) {
		super();
		this.id = id;
	}

	public Object getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "FileResource [id=" + id + "]";
	}

}