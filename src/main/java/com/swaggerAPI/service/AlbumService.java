package com.swaggerAPI.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swaggerAPI.domain.dto.AlbumDTO;

@Service
public interface AlbumService {
	public List<AlbumDTO> getAllAlbums();
	public AlbumDTO getAlbum(Long id);
	public AlbumDTO createNewAlbum(AlbumDTO albumDTO);
	public AlbumDTO saveAlbum(Long id, AlbumDTO albumDTO);
	public void deleteAlbumById(Long id);

	
}
