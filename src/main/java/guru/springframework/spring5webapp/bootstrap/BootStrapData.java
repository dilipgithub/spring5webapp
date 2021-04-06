package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private final AuthorRepository authorRepo;
	private final BookRepository bookRepo;
	private final PublisherRepository publisherRepo;
	
	public BootStrapData(AuthorRepository authorRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
		super();
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
		this.publisherRepo = publisherRepo;
	}



	@Override
	public void run(String... args) throws Exception {
		
		Publisher objPublisher = new Publisher("Publisher","Add","City","State","Zip");
		publisherRepo.save(objPublisher);
		
		Author objAuthor = new Author("Dilip","Mahajan");
		Book objBook = new Book("Book1","12345");
		objAuthor.getBooks().add(objBook);
		objBook.getAuthors().add(objAuthor);
		objPublisher.getBooks().add(objBook);
		objBook.setPublisher(objPublisher);
		
		
		
		
		authorRepo.save(objAuthor);
		bookRepo.save(objBook);
		publisherRepo.save(objPublisher);
		
		Author objAuthor2 = new Author("Sunil","Mahajan");
		Book objBook2 = new Book("Book1","12345");
		objAuthor2.getBooks().add(objBook2);
		objBook2.getAuthors().add(objAuthor2);
		objBook2.setPublisher(objPublisher);
		objPublisher.getBooks().add(objBook2);
		
		authorRepo.save(objAuthor2);
		bookRepo.save(objBook2);
		publisherRepo.save(objPublisher);
		
		System.out.println("BootStrap Started");
		System.out.println("Number Of Books = "+bookRepo.count());
		System.out.println(objPublisher.getBooks().size());
	}

}
