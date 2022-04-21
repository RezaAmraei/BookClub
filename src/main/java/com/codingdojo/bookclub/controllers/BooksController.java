package com.codingdojo.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.services.BookService;

@Controller
public class BooksController {
	@Autowired 
	private BookService bookService;
	
	@RequestMapping("/add/book")
	public String addBook(@ModelAttribute("newBook")Book book, BindingResult result, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("userId", session.getAttribute("userId"));
		System.out.println(session.getAttribute("userId"));
		return "addbook.jsp";
	}
	
	@PostMapping("/create/book")
	public String createBook(@Valid @ModelAttribute("newBook") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addbook.jsp";
		}
		System.out.println(book.getTitle());
		bookService.addBook(book);
		//book.setUser(book.getUser());
		return "redirect:/home";
	}
	@RequestMapping("/view/book/{id}")
	public String viewBook(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Book book = bookService.findBookById(id);
		model.addAttribute("book",book);
		model.addAttribute("userId", session.getAttribute("userId"));
		
		return "viewbook.jsp";
	}
}
