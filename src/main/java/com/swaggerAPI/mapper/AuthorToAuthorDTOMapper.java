package com.swaggerAPI.mapper;

import org.springframework.stereotype.Component;

import com.swaggerAPI.domain.dto.AuthorDTO;
import com.swaggerAPI.persistence.entity.Author;

@Component
public class AuthorToAuthorDTOMapper {

	public AuthorDTO authorToAuthorDTO (Author author) {
		if (null == author ) { return null; }
		
		return new AuthorDTO(author.getId(), author.getName());
	}
	
	public Author authorDTOToAuthor (AuthorDTO authorDTO) {
		if (null == authorDTO ) { return null; }
		
		return new Author(authorDTO.getId(), authorDTO.getName());
	}
}
