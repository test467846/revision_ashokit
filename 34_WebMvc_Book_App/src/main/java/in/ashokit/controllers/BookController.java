package in.ashokit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.ashokit.entities.Book;
import in.ashokit.services.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ModelAndView getBooks() {

		ModelAndView mav = new ModelAndView();
		List<Book> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("booksView");
		return mav;

	}
	@GetMapping("/index")
	public ModelAndView displayForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("book",new Book());
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/edit")
	public ModelAndView editBook(@RequestParam("bookId") Integer bookId) {
		Book bookById = bookService.getBookById(bookId);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", bookById);
		mav.setViewName("index");
		return mav;
	}
	
	@PostMapping("/book")
	public ModelAndView saveBook(Book book) {
		
		ModelAndView mav= new ModelAndView();
		boolean status = bookService.saveBook(book);
		if(status) {
			mav.addObject("succMsg","Book Saved");
		}else {
			mav.addObject("errMsg","Book Not Saved");
		}
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId") Integer  bookId) {
		bookService.deleteBook(bookId);
		
		ModelAndView mav = new ModelAndView();
		List<Book> allBooks = bookService.getAllBooks();
		mav.addObject("books", allBooks);
		mav.setViewName("booksView");
		return mav;
	}

}
