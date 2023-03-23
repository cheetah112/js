package App2.app2.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table
public class Todo {
    @Id
    @Column(name = "TodoID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Todo", nullable = false)
    private String title;
    @Column(name = "Trạng thái")
    private Boolean status;
}
