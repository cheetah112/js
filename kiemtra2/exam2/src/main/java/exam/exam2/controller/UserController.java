package exam.exam2.controller;
import exam.exam2.Dto.CourseDto;
import exam.exam2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    UserService userService = new UserService();

    @GetMapping("/courses")
    public List<CourseDto> getCourses(@RequestParam(required = false) String type, @RequestParam(required = false) String name, @RequestParam(required = false) String topic) {
        return userService.getCourses(type,name,topic);
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable Integer id){
        return userService.findCourseById(id);
    }

}
