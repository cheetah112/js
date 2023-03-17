package com.example.shoppingcartbackend.db;

import com.example.shoppingcartbackend.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {
    public static List<Course> courses = new ArrayList<>(
            List.of(new Course(1,"java 1", "java fullstack", "onlab",CategoryDB.categories,"a",20000000,4.5,1),
                    new Course(2, "python 1", "python full", "online",CategoryDB.categories,"b", 18000000,4.3,1),
                    new Course(3,"java 2", "java fullstack", "online",CategoryDB.categories ,"a1",20000000,4.5,2),
                    new Course(4,"python 2", "python full", "onlab",CategoryDB.categories ,"b1",18000000,4.5,2)
                    )
    );
}
