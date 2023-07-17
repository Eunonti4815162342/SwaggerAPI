package com.swaggerAPI.persistence.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.swaggerAPI.persistence.entity.Album;

public interface AlbumRepository  extends PagingAndSortingRepository<Album, Long> {
    List<Album> findByName(String name);
}