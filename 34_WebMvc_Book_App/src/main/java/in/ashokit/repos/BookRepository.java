package in.ashokit.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entities.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public List<Book> findByActiveSw(String status);

}
