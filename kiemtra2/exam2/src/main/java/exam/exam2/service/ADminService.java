package exam.exam2.service;

import exam.exam2.Dto.AdminDto;
import exam.exam2.Dto.CourseDto;
import exam.exam2.Mapper.CourseMapper;
import exam.exam2.db.CourseDb;
import exam.exam2.model.Course;
import exam.exam2.repository.CourseRepository;
import exam.exam2.request.UpsertCourseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ADminService {
    CourseRepository courseRepository = new CourseRepository();
    CourseMapper courseMapper = new CourseMapper();

    public AdminDto findAllByAdmin(Integer page, Integer pageSize) {
        return courseRepository.findAllByAdmin(page, pageSize);
    }

    public ResponseEntity<?> addCourse(UpsertCourseRequest request){

            Course course = new Course();
            course.setId(CourseDb.courses.size() + 1);
            course.setName(request.getName());
            course.setType(request.getType());
            course.setTopics(request.getToppics());
            course.setThubnail(request.getThumbnail());
            course.setDescription(request.getDescription());
            course.setUserId(request.getUserId());
            CourseDb.courses.add(course);
            return ResponseEntity.ok(courseMapper.mapper(course));
     }


    public ResponseEntity<?> updateCourseById(UpsertCourseRequest request, Integer id) {
        return courseRepository.updateCourseById(request, id);
    }

    public ResponseEntity<?> deleteCourseById(Integer id) {
        return courseRepository.deleteCourseById(id);
    }
}
