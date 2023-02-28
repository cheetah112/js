package exam.exam2.db;
import exam.exam2.model.Course;
import java.util.ArrayList;
import java.util.List;

public class CourseDb {
    public static List<Course> courses = new ArrayList<>(
            List.of(
                    new Course(1,"java1","javascrip1","online",List.of("frontend","backend"),"java1",1),
                    new Course(2,"java2","javascrip2","onlab",List.of("frontend","backend"),"java1",2),
                    new Course(3,"java3","javascrip3","online",List.of("frontend","backend"),"java1",3),
                    new Course(4,"java4","javascrip4","onlab",List.of("frontend","backend"),"java1",4),
                    new Course(5,"java5","javascrip5","online",List.of("frontend","backend"),"java1",5),
                    new Course(6,"java6","javascrip6","onlab",List.of("frontend","backend"),"java1",6),
                    new Course(7,"java1","javascrip1","online",List.of("frontend","backend"),"java1",1),
                    new Course(8,"java2","javascrip2","onlab",List.of("frontend","backend"),"java1",2),
                    new Course(9,"java3","javascrip3","online",List.of("frontend","backend"),"java1",3),
                    new Course(10,"java4","javascrip4","onlab",List.of("frontend","backend"),"java1",4),
                    new Course(11,"java5","javascrip5","online",List.of("frontend","backend"),"java1",5),
                    new Course(12,"java6","javascrip6","onlab",List.of("frontend","backend"),"java1",6),
                    new Course(13,"java1","javascrip1","online",List.of("frontend","backend"),"java1",1),
                    new Course(14,"java2","javascrip2","onlab",List.of("frontend","backend"),"java1",2),
                    new Course(15,"java3","javascrip3","online",List.of("frontend","backend"),"java1",3),
                    new Course(16,"java4","javascrip4","onlab",List.of("frontend","backend"),"java1",4),
                    new Course(17,"java5","javascrip5","online",List.of("frontend","backend"),"java1",5),
                    new Course(18,"java6","javascrip6","onlab",List.of("frontend","backend"),"java1",6)

            )
    );
}
