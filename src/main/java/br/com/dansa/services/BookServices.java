package br.com.dansa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dansa.converter.DozerConverter;
import br.com.dansa.entity.Book;
import br.com.dansa.exception.PersonNotFoundException;
import br.com.dansa.model.BookModel;
import br.com.dansa.repositories.BookRepositoty;

@Service
public class BookServices {
	
	@Autowired
	private BookRepositoty bookRepositoty;
	
	public List<BookModel> getAll() {
		return DozerConverter.parseListObjects(bookRepositoty.findAll(), BookModel.class);
	}
	
	public BookModel findById(Long id) {
		var entity = bookRepositoty.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
		return DozerConverter.parseObject(entity, BookModel.class);
	}
	
	public BookModel create(BookModel bookModel) {
		
		var entity = DozerConverter.parseObject(bookModel, Book.class);
		var vo = DozerConverter.parseObject(bookRepositoty.save(entity), BookModel.class);
		return vo;
		
	}
	
	public BookModel update(BookModel bookModel) {
		var entity = bookRepositoty.findById(bookModel.getId())
				.orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
		entity.setAuthor(bookModel.getAuthor());
		entity.setLauchDate(bookModel.getLauchDate());
		entity.setPrice(bookModel.getPrice());
		entity.setTitle(bookModel.getTitle());
		
		return DozerConverter.parseObject(bookRepositoty.save(entity), BookModel.class);
	}
	
	public void delete(Long id) {
		var entity = bookRepositoty.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("No records for this ID"));
		bookRepositoty.delete(entity);
	}

}
