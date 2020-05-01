/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.studentinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 1.0.0 2020年5月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class StudentInfoManageSystem {

	private List<Student> studentList = new ArrayList<>();

	public void addStudent(Student student) {
		// 如果已经添加了过该用户的信息，则提示用户。
		// 否则将用户信息添加到系统中，并给出提示。
		if (studentList.contains(student)) {
			System.out.println("Student exsit");
		} else {
			studentList.add(student);
			System.out.println("Add student success");
		}
	}

	public void removeStudent(Student student) {
		// 如果用户信息不存在于系统中，则提示用户。
		// 否则将用户信息从系统中删除，并给出提示。
		if (studentList.contains(student)) {
			studentList.remove(student);
			System.out.println("Remove student success");
		} else {
			System.out.println("Student not exsit");
		}
	}

	public List<Student> getStudentList() {
		// 如果系统中不存在用户，则提示用户。
		// 否则将用户信息查询出来返回，并将用户信息打印出来。
		if (studentList.isEmpty()) {
			System.out.println("No student exsit");
		} else {
			for (Student s : studentList) {
				System.out.format("Student info: name %s, age %d, phone %s, address %s%n", 
						s.getName(), s.getAge(), s.getPhoneNumer(), s.getAddress());
			}
		}

		return studentList;
	}
}
