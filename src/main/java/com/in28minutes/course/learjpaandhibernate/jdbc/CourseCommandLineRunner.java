package com.in28minutes.course.learjpaandhibernate.jdbc;

import com.in28minutes.course.learjpaandhibernate.Course;
import com.in28minutes.course.learjpaandhibernate.jpa.CourseJpaRepository;
import com.in28minutes.course.learjpaandhibernate.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJpaRepository repository;  //uso de JPA
//
//    @Autowired
//    private CourseJdbcRepository repository;  //uso de JDBC

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "in28minutes"));
        repository.save(new Course(2, "Learn Cloud", "in30minutes"));
        repository.save(new Course(3, "Learn JPA", "in28minutes"));
        //repository.insert(new Course(3, "Learn JPA", "in28minutes"));    INSERT para JDBC E JPA

        repository.deleteById(2l);

        System.out.println(repository.findById(3l));
        System.out.println(repository.findById(1l));
    }
}
