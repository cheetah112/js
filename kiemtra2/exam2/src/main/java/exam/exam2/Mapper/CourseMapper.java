package exam.exam2.Mapper;

import exam.exam2.Dto.CourseDto;
import exam.exam2.db.UserDb;
import exam.exam2.model.Course;

public class CourseMapper {
    public CourseDto mapper(Course course){
        CourseDto courseDto = new CourseDto(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getType(),
                course.getTopics(),
                course.getThubnail(),
                UserDb.users.stream().filter(user -> user.getId() == course.getUserId())
                        .findFirst().get());
        return courseDto;
    }
}
