package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		/**
		 * Initiate students
		 */
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		/**
		 * Initiate students of Student[] type
		 */
		students = new Student[numOfStudents];
		int i = 0;
		
		/**
		 * Put divided lines to instanceOfStudent
		 */
		for(int k = 0; k < lines.length; k++) {
			Student instanceOfStudent = new Student(lines[k].split(",")[1].trim());
			
			/**
			 * If instanceOfStudent is not in students, input instanceOfStudent to students
			 */
			if(studentExist(students, instanceOfStudent) == false) {
				students[i] = instanceOfStudent;
				i++;
			}
			
		}
		return students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		for(Student student_exist: students) {
			
			/**
			 * If students is null, return false
			 */
			if (student_exist == null) {
				return false;
			}
			else {
				/**
				 * If student and student_exist are same, return true
				 */
				if (student.getName().equals(student_exist.getName())) {
					return true;
				}
			}
		}

		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		/**
		 * Initiate students of Course[] type
		 */
		courses = new Course[numOfCourses];
		int i = 0;
		
		/**
		 * Put divided lines to instanceOfCourse
		 */
		for(int k = 0; k < lines.length; k++) {	
			Course instanceOfCourse = new Course(lines[k].split(",")[2].trim());
			
			/**
			 * If instanceOfCourse is not in courses, input instanceOfCourse to courses
			 */
			if(courseExist(courses, instanceOfCourse) == false) {
				courses[i] = instanceOfCourse;
				i++;
			}
			
		}
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		/**
		 * If courses is null, return false
		 */
		for(Course course_exist: courses) {
			if (course_exist == null) {
				return false;
			}
			else {
				/**
				 * If course and course_exist are same, return true
				 */
				if (course.getCourseName().equals(course_exist.getCourseName())) {
					return true;
				}
			}
		}

		return false;
	}

}
