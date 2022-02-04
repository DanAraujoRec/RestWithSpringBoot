package br.com.dansa.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookModel extends RepresentationModel<BookModel> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;		
	private String author;
	private Date lauchDate;	
	private Double price;
	private String title;
}
