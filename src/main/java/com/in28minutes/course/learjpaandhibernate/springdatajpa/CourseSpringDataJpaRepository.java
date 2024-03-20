package com.in28minutes.course.learjpaandhibernate.springdatajpa;

import com.in28minutes.course.learjpaandhibernate.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {


}
