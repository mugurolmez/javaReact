package kodlama.io.hrms.dataAcces.abstracts;

import kodlama.io.hrms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findBynationalityId(String nationalityId);
    User findByEmail(String email);

}
