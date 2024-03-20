package com.in28minutes.course.learjpaandhibernate.jdbc;

import com.in28minutes.course.learjpaandhibernate.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository  //anotacao que define quando uma classe se comunca com um BD
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTeplate;

    private static String INSERT_QUERY =
                    """
                    insert into course(id, name, author)
                    values (?, ?, ?);
                    """;

    public static String DELETE_QUERY =
                    """
                    delete from course
                    where id = ?
                    """;

    public static String SELECT_QUERY =
            """
            select * from course
            where id = ?
            """;

    public void insert(Course course) {
        springJdbcTeplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id){
        springJdbcTeplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id){

        return springJdbcTeplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),
                id);
    }
}
