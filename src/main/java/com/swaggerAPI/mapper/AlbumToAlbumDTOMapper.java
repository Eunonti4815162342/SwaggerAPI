package com.swaggerAPI.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swaggerAPI.domain.dto.AlbumDTO;
import com.swaggerAPI.persistence.entity.Album;

@Component
public class AlbumToAlbumDTOMapper {

	@Autowired
	private AuthorToAuthorDTOMapper authorToAuthorDTOMapper;

	public AlbumDTO albumToAlbumDTO(Album album) {
		if (null == album) {
			return null;
		}

		AlbumDTO albumDTO = new AlbumDTO();

		albumDTO.setId(album.getId());
		albumDTO.setName(album.getName());
		albumDTO.setCreatedAt(album.getCreatedAt());
		albumDTO.setAuthorDTO(authorToAuthorDTOMapper.authorToAuthorDTO(album.getAuthor()));

		return albumDTO;
	}

	public Album albumDTOToAlbum(AlbumDTO albumDTO) {
		if (null == albumDTO) {
			return null;
		}

		Album album = new Album();

		album.setName(albumDTO.getName());
		album.setCreatedAt(albumDTO.getCreatedAt());
		album.setAuthor(authorToAuthorDTOMapper.authorDTOToAuthor(albumDTO.getAuthorDTO()));

		return album;
	}
}
