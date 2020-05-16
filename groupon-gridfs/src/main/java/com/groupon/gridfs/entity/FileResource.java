package com.groupon.gridfs.entity;

public class FileResource {


	private String id;
	private String title;
	private String description;
	private String category;
	private String userName;
	
	
	public FileResource(String id, String title, String description, String category, String userName) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

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
		return "FileResource [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", userName=" + userName + "]";
	}
  
}