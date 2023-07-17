package com.swaggerAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swaggerAPI.domain.dto.AlbumDTO;
import com.swaggerAPI.mapper.AlbumToAlbumDTOMapper;
import com.swaggerAPI.persistence.entity.Album;
import com.swaggerAPI.persistence.repository.AlbumRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

	
	private AlbumToAlbumDTOMapper albumToAlbumDTOMapper;
	
	@Autowired
	private AlbumRepository albumRepository;

	public AlbumServiceImpl(AlbumToAlbumDTOMapper albumToAlbumDTOMapper, AlbumRepository albumRepository) {
		this.albumToAlbumDTOMapper = albumToAlbumDTOMapper;
		this.albumRepository = albumRepository;
	}

	@Override
	public List<AlbumDTO> getAllAlbums() {
		Iterable<Album> albums = albumRepository.findAll();
		List<AlbumDTO> albumDTOs = new ArrayList<AlbumDTO>();

		for (Album v : albums) {
			albumDTOs.add(albumToAlbumDTOMapper.albumToAlbumDTO(v));
		}

		return albumDTOs;
	}

	@Override
	public AlbumDTO getAlbum(Long id) {
		return albumToAlbumDTOMapper.albumToAlbumDTO(albumRepository.findById(id).get());
	}

	@Override
	public AlbumDTO createNewAlbum(AlbumDTO albumoDTO) {
		return saveAlbum(null, albumoDTO);
	}

	@Override
	public AlbumDTO saveAlbum(Long id, AlbumDTO videoDTO) {
		Album video = albumRepository.save(albumToAlbumDTOMapper.albumDTOToAlbum(videoDTO));

		return albumToAlbumDTOMapper.albumToAlbumDTO(video);
	}

	@Override
	public void deleteAlbumById(Long id) {
		albumRepository.deleteById(id);

	}

}
