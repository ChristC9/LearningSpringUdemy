package com.chriscode.cruddemo_advanced.dao;

import com.chriscode.cruddemo_advanced.entity.Course;
import com.chriscode.cruddemo_advanced.entity.Instructor;
import com.chriscode.cruddemo_advanced.entity.InstructorDetails;

import java.util.List;

public interface AppDAO {

    void saveInstructor (Instructor instructor);
    void saveCourse (Course course);
    Instructor findInstructorbyId(int id);
    InstructorDetails findbyId (int id);
    void deleteInstructorDetails(int id);
    List<Course> findCoursesByInstructorId (int theId);

    void UpdateInstructor(Instructor instructor);

    void UpdateCourse(Course course);

    Course findCourseById(int id);

    void deleteInsturctor(Instructor instructor);
}
