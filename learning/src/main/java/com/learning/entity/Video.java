package com.learning.entity;

public class Video {
	private String name;
	private byte[] content;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public Video(String name, byte[] content) {
		super();
		this.name = name;
		this.content = content;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
