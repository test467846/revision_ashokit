package in.ashokit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entities.Book;
import in.ashokit.repos.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {

		return bookRepo.findByActiveSw("Y");
	}

	@Override
	public boolean saveBook(Book book) {
		book.setActiveSw("Y");
		Book savedBook = bookRepo.save(book);
		if(savedBook.getBookId()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public void deleteBook(Integer bookId) {
		
		//Hard Delete or Permanent delete
		//bookRepo.deleteById(bookId);
		
		//soft delete
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			Book book = findById.get();
			book.setActiveSw("N");
			bookRepo.save(book);
		}
		
		
	}

	@Override
	public Book getBookById(Integer bookId) {
		Optional<Book> findById = bookRepo.findById(bookId);
		if(findById.isPresent()) {
			return findById.get();
		}
		
		return null;
	}

}
