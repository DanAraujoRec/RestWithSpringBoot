package br.com.dansa.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dansa.entity.Book;
import br.com.dansa.model.BookModel;
import br.com.dansa.services.BookServices;

@RequestMapping("/books")
@RestController
public class BookController {

	@Autowired
	private BookServices bookServices;

	@GetMapping
	public List<BookModel> findAll() {
		List<BookModel> bookModels = bookServices.getAll();

		bookModels.stream().forEach(
				book -> book.add(linkTo(methodOn(BookController.class).findById(book.getId())).withSelfRel()));
		return bookModels;
	}

	@GetMapping("/{id}")
	public BookModel findById(@PathVariable Long id) {
		BookModel bookModel = bookServices.findById(id);
		bookModel.add(linkTo(methodOn(BookController.class).findById(bookModel.getId())).withSelfRel());
		return bookModel;
	}

	@PostMapping()
	public BookModel create(@RequestBody BookModel book) {

		BookModel bookModel = bookServices.create(book);

		bookModel.add(linkTo(methodOn(BookController.class).findById(bookModel.getId())).withSelfRel());

		return bookModel;
	}

	@PutMapping()
	public BookModel update(@RequestBody BookModel book) {

		BookModel bookModel = bookServices.update(book);

		bookModel.add(linkTo(methodOn(BookController.class).findById(bookModel.getId())).withSelfRel());

		return bookModel;
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Book> delete(@PathVariable Long id) {

		bookServices.delete(id);
		return ResponseEntity.ok().build();
	}

}
