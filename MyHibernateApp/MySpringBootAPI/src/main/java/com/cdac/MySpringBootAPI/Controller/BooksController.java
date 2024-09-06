package com.cdac.MySpringBootAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.MySpringBootAPI.Model.Books;
import com.cdac.MySpringBootAPI.Service.BooksService;

@RestController
public class BooksController {
//autowire the BooksService class
	@Autowired //(required = true)
	BooksService booksService;

//creating a get mapping that retrieves all the books detail from the database 
	@GetMapping("/books")
	private List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

//creating a get mapping that retrieves the detail of a specific book
	@GetMapping("/books/{bookId}")
	private Books getBooks(@PathVariable("bookId") int bookId) {
		return booksService.getBooksById(bookId);
	}

//creating a delete mapping that deletes a specified book
	@DeleteMapping("/books/{bookId}")
	private void deleteBook(@PathVariable("bookId") int bookId) {
		booksService.delete(bookId);
	}

//creating post mapping that post the book detail in the database
	@PostMapping("/books")
	private int saveBook(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books.getBookId();
	}

//creating put mapping that updates the book detail 
	@PutMapping("/books")
	private Books update(@RequestBody Books books) {
		booksService.saveOrUpdate(books);
		return books;
	}
}
