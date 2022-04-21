package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.repositories.BookRepository;
import com.codingdojo.bookclub.repositories.UserRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired UserRepository userRepository;
	//Create Book
	public Book addBook(Book book) {
		//book.setUser(null);
		return bookRepository.save(book);
	}
	//Edit Book
	
	//Delete Book
	
	//View All Books
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	//Find Book By Id
	public Book findBookById(Long id) {
		Optional<Book> maybeBook = bookRepository.findById(id);
		if(maybeBook.isPresent()) {
			return maybeBook.get();
		}else {
			return null;
		}
	}
}
