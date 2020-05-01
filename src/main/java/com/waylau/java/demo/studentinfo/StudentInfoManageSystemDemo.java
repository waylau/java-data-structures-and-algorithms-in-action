/**
 * Welcome to https://waylau.com
 */
package com.waylau.java.demo.studentinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * StudentInfoManageSystem Demo.
 * 
 * @since 1.0.0 2020年5月1日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class StudentInfoManageSystemDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 初始化系统
		StudentInfoManageSystem system = new StudentInfoManageSystem();

		// 初始化学生信息
		Student student = new Student(32, "Way Lau", "17088888888", "Shenzhen");

		// 添加学生
		system.addStudent(student); // Add student success

		// 再次添加学生
		system.addStudent(student); // Student exsit

		// 第一次查询所有学生
		List<Student> studentList = system.getStudentList();

		// 删除学生
		system.removeStudent(student); // Remove student success

		// 再次删除学生
		system.removeStudent(student); // Student not exsit

		// 查询所有学生
		studentList = system.getStudentList(); // No student exsit

	}

}
