package com.arcade.springrest.service;

import com.arcade.springrest.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getCourses();

    Course getCourse(Long courseId);

    Course addCourse(Course course);
}
