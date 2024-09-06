package com.cdac.MySpringBootAPI.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdac.MySpringBootAPI.Repository.BooksRepository;
import com.cdac.MySpringBootAPI.Model.Books;

//Defining Buisness Logic
public class BooksService {

	@Autowired
	BooksRepository booksRepository;

	// Getting All books Records by using the method Finall() of cruid Repository
	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}

	public Books getBooksById(int id) {
		return booksRepository.findById(id).get();
	}

	// saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(int id) {
		booksRepository.deleteById(id);
	}

	// updating a record
	public void update(Books books, int bookId) {
		booksRepository.save(books);
	}

}
