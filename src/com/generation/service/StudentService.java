package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.*;

public class StudentService
{
    private final HashMap<String, Student> students = new HashMap<>();

    public void subscribeStudent(Student student)
    {
        // Registering a student using .getId() method from student:
        if (!students.containsKey(student.getId())) {
            students.put( student.getId(), student );
            System.out.println("Student has been registered successfully!");
        } else {
            System.out.println("Student has been registered before!");
        }
    }

    public Student findStudent( String studentId )
    {
        //
        if (students.containsKey(studentId)) {
            return students.get(studentId);
        }
        return null;
    }

    public boolean showSummary()
    {
        if (!students.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean enrollToCourse( String studentId, Course course )
    {
        //
        if (students.containsKey(studentId)) {
            students.get(studentId).enrollToCourse(course);
            return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        String summary = "";
        for(Student student: students.values()){
            summary += student + "\n";
            summary += "Enrolled Courses:\n";
            for (Course course: student.getEnrolledCourses()) {
                summary += course;
            }
        }
        return summary;
    }

}
