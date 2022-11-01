package com.arcade.springrest.service;

import com.arcade.springrest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {

    List<Course> list;

    public CourseServiceImpl() {
        list = new ArrayList<>();
        list.add(new Course(1L, "new data record", "no description"));
        list.add(new Course(2L, "2 data record", "2 no description"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(Long courseId) {
        Course c = null;
        for (Course course : list) {
            if (Objects.equals(course.getId(), courseId)) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }
}
