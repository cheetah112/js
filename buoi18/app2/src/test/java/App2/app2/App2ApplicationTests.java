package App2.app2;

import App2.app2.entity.Todo;
import App2.app2.repository.TodoRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class App2ApplicationTests {
	@Autowired
	private TodoRepository todoRepository;
	@Test
	@Rollback(value = false)
	void save_todo() {
		Faker faker = new Faker();
		for (int i = 0; i < 30; i++) {
			Todo todo = Todo.builder()
					.title(faker.job().keySkills())
					.status(false)
					.build();

			todoRepository.save(todo);
		}

	}

}
