package exam.exam2.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AdminDto {
    private Integer curentPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalItems;
    private List<CourseDto> data;

}
