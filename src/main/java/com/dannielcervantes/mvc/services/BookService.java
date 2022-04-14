package com.dannielcervantes.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dannielcervantes.mvc.models.Book;
import com.dannielcervantes.mvc.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	// return all the books
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	// creates a book
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	// updates book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	// delete book
	public void deleteBook(long id) {
		bookRepository.deleteById(id);
	}
}
