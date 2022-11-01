package com.arcade.springrest.controller;

import com.arcade.springrest.entity.Course;
import com.arcade.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ApiController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "Hello world!";
    }

    //    get courses
    @GetMapping("/courses")
    public List<Course> getCources() {
        return courseService.getCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable Long courseId) {
        return courseService.getCourse(courseId);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }
}
