package exam.exam2.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpsertCourseRequest {
    @NotNull(message = "Name not Null")
    private String name;
    @NotNull(message = "Description not Null")
    @Size(min = 51, message = "description > 50 char")
    private String description;
    @NotNull(message = "type not Null")
    private String type;
    private List<String> toppics;
    private String thumbnail;
    @NotNull(message = "Id not Null")
    private Integer userId;
}
