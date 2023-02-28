package exam.exam2.service;
import exam.exam2.Dto.CourseDto;
import exam.exam2.model.Course;
import exam.exam2.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {

    CourseRepository courseRepository = new CourseRepository();

    public List<CourseDto> getCourses(String type, String name, String topic) {
        return courseRepository.getCourses(type,name,topic);
    }

    public ResponseEntity<?> findCourseById(Integer id) {
        CourseDto course = courseRepository.findCourseById(id);
        return ResponseEntity.ok(course);
    }

}
