package com.infobeans.model;

public class Student {
	private int s_id;
	private String s_name;
	//private String sf_name;
	private int s_class;

	private int t_id;
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	
	public int getS_class() {
		return s_class;
	}
	public void setS_class(int s_class) {
		this.s_class = s_class;
	}

	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public Student(int s_id, String s_name,  int s_class, int t_id) {
		super();
		this.s_id = s_id;
		this.s_name = s_name;
		// this.sf_name = sf_name;
		this.s_class = s_class;
		
		this.t_id = t_id;
	}
}
