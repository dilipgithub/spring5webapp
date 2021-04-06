package guru.springframework.spring5webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {
	
	private final BookRepository bookrepo;
	
	
	public BookController(BookRepository bookrepo) {
		super();
		this.bookrepo = bookrepo;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("books",bookrepo.findAll());
		return "books/list";
	}

}
