/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.studentinfo;

/**
 * Student.
 * 
 * @since 1.0.0 2020年5月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class Student {
	private Integer age; // 年龄
	private String name; // 姓名
	private String phoneNumer; // 电话号码
	private String address; // 地址

	public Student(Integer age, String name, String phoneNumer, String address) {
		super();
		this.age = age;
		this.name = name;
		this.phoneNumer = phoneNumer;
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumer() {
		return phoneNumer;
	}

	public void setPhoneNumer(String phoneNumer) {
		this.phoneNumer = phoneNumer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
