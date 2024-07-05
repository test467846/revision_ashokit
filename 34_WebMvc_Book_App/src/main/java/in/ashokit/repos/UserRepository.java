package in.ashokit.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
