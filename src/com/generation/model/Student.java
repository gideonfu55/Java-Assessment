package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{
    private List<Course> enrolledCourses;

    float PASS_MIN_GRADE = 3.0f;

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );

        // Create an empty enrolledCourses ArrayList:
        enrolledCourses = new ArrayList<>();

    }

    public boolean enrollToCourse(Course course)
    {
        //Add Course to student's course ArrayList
        if (!enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            return true;
        }
        return false;
    }

    @Override
    public List<Course> findPassedCourses()
    {
        //TODO
        return enrolledCourses.stream().filter(course -> course.getGrade() >= PASS_MIN_GRADE).toList();
    }

    public Course findCourseById( String courseId )
    {
        //TODO
        for (Course course: enrolledCourses) {
            if(course.getCode().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        return enrolledCourses;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}


