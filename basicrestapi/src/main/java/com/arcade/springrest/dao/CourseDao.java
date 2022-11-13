package com.arcade.springrest.dao;

import com.arcade.springrest.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
