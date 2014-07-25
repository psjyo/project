package com.dto;

public class ProjectInfoDTO {
	
	String job;
	String process;
	String name;
	public ProjectInfoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjectInfoDTO(String job, String process, String name) {
		super();
		this.job = job;
		this.process = process;
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
