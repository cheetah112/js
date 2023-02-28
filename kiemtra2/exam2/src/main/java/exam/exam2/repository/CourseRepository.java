package exam.exam2.repository;
import exam.exam2.Dto.AdminDto;
import exam.exam2.Dto.CourseDto;
import exam.exam2.Mapper.CourseMapper;
import exam.exam2.db.CourseDb;
import exam.exam2.exception.NotFoundException;
import exam.exam2.model.Course;
import exam.exam2.request.UpsertCourseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class CourseRepository {
    CourseMapper courseMapper = new CourseMapper();
        public List<CourseDto> getCourses(String type, String name, String topic) {
            List<CourseDto> courseDtoList = getAllCourseDto();
            List<CourseDto> ans = new ArrayList<>();
        if (type != null && name != null && topic != null){
            ans.addAll(courseDtoList.stream()
                    .filter(course -> course.getType().equals(type)
                            && course.getName().equals(name)
                            && course.getTopics().contains(topic))
                    .toList());
       }
        if (type == null && name != null && topic != null){
            ans.addAll(courseDtoList.stream()
                    .filter(course -> course.getName().equals(name)
                            && course.getTopics().contains(topic))
                    .toList());
        }
        if (type == null && name == null && topic != null){
            ans.addAll(courseDtoList.stream()
                    .filter(course -> course.getTopics().contains(topic))
                    .toList());
        }
         if (type == null && name != null && topic == null){
             ans.addAll(courseDtoList.stream()
                     .filter(course -> course.getName().equals(name))
                     .toList());
         }
         if (type != null && name == null && topic == null){
             ans.addAll(courseDtoList.stream()
                     .filter(course -> course.getType().equals(type))
                     .toList());
         }
         if (type != null && name == null && topic != null){
             ans.addAll(courseDtoList.stream()
                     .filter(course -> course.getType().equals(type)
                             && course.getTopics().contains(topic))
                     .toList());
         }
         if (type != null && name != null && topic == null){
             ans.addAll(courseDtoList.stream()
                     .filter(course -> course.getType().equals(type)
                             && course.getName().equals(name))
                     .toList());
         }
         if (type == null && name == null && topic == null){
             ans.addAll(courseDtoList);
         }
        return ans;
    }

    public List<CourseDto> getAllCourseDto() {
            List<CourseDto> courseDtoList = new ArrayList<>();
            for(int i = 0; i < CourseDb.courses.size(); i++){
                Course course = CourseDb.courses.get(i);
                CourseDto courseDto = courseMapper.mapper(course);
                courseDtoList.add(courseDto);
            }
            return courseDtoList;
    }


    public CourseDto findCourseById(Integer id) {
            List<CourseDto> courseDtoList = getAllCourseDto();
            Optional<CourseDto> courseDtoOptional = courseDtoList.stream()
                .filter(courseDto -> courseDto.getId() == id)
                .findFirst();
            if(courseDtoOptional.isPresent()){
                return courseDtoOptional.get();
            }

            throw new NotFoundException("No Course found");
    }


    public AdminDto findAllByAdmin(Integer page, Integer pageSize) {
        List<CourseDto> courseDtoList = getAllCourseDto();
        AdminDto adminDto = new AdminDto();
        adminDto.setCurentPage(page);
        adminDto.setTotalItems(courseDtoList.size());
        adminDto.setPageSize(pageSize);
        double totalPage = courseDtoList.size()/pageSize;
        adminDto.setTotalPage((int) Math.ceil(totalPage));
        List<CourseDto> data = new ArrayList<>();
        for (int i = (page-1)*pageSize; i < ((page*pageSize)) && i < adminDto.getTotalItems(); i++){
            data.add(courseDtoList.get(i));
        }
        adminDto.setData(data);
        return adminDto;
    }

    public ResponseEntity<?> updateCourseById(UpsertCourseRequest request, Integer id) {
        for (Course course: CourseDb.courses) {
            if(course.getId() == id){
                course.setName(request.getName());
                course.setDescription(request.getDescription());
                course.setType(request.getType());
                course.setTopics(request.getToppics());
                course.setThubnail(request.getThumbnail());
                course.setUserId(request.getUserId());
                return ResponseEntity.ok(courseMapper.mapper(course));
            }
        }
        throw new NotFoundException("No Course found");
    }

    public ResponseEntity<?> deleteCourseById(Integer id) {
        for (Course course: CourseDb.courses) {
            if (course.getId() == id ) {
                CourseDb.courses.remove(course);
                return ResponseEntity.ok("Xoa Thanh Cong");
            }
        }
        throw new NotFoundException("No Course found");
    }
}
