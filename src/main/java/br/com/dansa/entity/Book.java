package br.com.dansa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "books")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
		
	@Column(length = 180, nullable = false)
	private String author;
	
	@Column(name = "lauch_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date lauchDate;
	
	@Column(nullable = false)
	private Double price;
	
	@Column(length = 250, nullable = false)
	private String title;

}
