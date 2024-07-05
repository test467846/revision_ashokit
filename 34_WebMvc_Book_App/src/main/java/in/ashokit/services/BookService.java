package in.ashokit.services;

import java.util.List;

import in.ashokit.entities.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public boolean saveBook(Book book);
	
	public void deleteBook(Integer bookId);
	
	public Book getBookById(Integer bookId);

}
