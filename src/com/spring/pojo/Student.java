package com.spring.pojo;

public class Student {
	private Integer stuId;
	private String stuName;
	private String stuCity;
	private Integer stuAge;
	private Integer gradeId;
	public Student() {
	}
	public Student(String stuName, String stuCity, Integer stuAge, Integer gradeId) {
		super();
		this.stuName = stuName;
		this.stuCity = stuCity;
		this.stuAge = stuAge;
		this.gradeId = gradeId;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuCity=" + stuCity + ", stuAge=" + stuAge
				+ ", gradeId=" + gradeId + "]";
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuCity() {
		return stuCity;
	}
	public void setStuCity(String stuCity) {
		this.stuCity = stuCity;
	}
	public Integer getStuAge() {
		return stuAge;
	}
	public void setStuAge(Integer stuAge) {
		this.stuAge = stuAge;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	
}
