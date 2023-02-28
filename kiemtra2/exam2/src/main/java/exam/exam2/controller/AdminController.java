package exam.exam2.controller;
import exam.exam2.Dto.AdminDto;
import exam.exam2.Dto.CourseDto;
import exam.exam2.exception.ConstraintViolationException;
import exam.exam2.model.Course;
import exam.exam2.model.User;
import exam.exam2.request.UpsertCourseRequest;
import exam.exam2.service.ADminService;
import exam.exam2.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    ADminService aDminService = new ADminService();
    UserService userService = new UserService();
    @GetMapping("/courses")
    public AdminDto findAllByAdmin(@RequestParam(required = false, defaultValue = "1") Integer page,
                                   @RequestParam(required = false, defaultValue = "10") Integer pageSize){
        return aDminService.findAllByAdmin(page, pageSize);
    }

    @PostMapping("/courses")
    public ResponseEntity<?> addCourse(@Valid @RequestBody UpsertCourseRequest request){
        return aDminService.addCourse(request);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable Integer id){
        return userService.findCourseById(id);
    }
    @PutMapping("/courses/{id}")
    public ResponseEntity<?> updateCourseById(@Valid @RequestBody UpsertCourseRequest request, @PathVariable Integer id){
        return aDminService.updateCourseById(request, id);
    }
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<?> deleteCourseById(@PathVariable Integer id){
        return aDminService.deleteCourseById(id);
    }
}
