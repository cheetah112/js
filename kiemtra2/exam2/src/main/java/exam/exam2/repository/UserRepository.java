package exam.exam2.repository;
import exam.exam2.db.UserDb;
import exam.exam2.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public User findUserById(Integer id){
        return UserDb.users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .get();
    }
}
