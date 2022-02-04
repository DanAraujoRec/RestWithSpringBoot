package br.com.dansa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dansa.entity.Book;

@Repository
public interface BookRepositoty extends JpaRepository<Book, Long>{

}
