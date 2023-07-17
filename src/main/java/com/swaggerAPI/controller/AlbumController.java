package com.swaggerAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.swaggerAPI.domain.dto.AlbumDTO;
import com.swaggerAPI.service.AlbumService;


@Controller
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	
    @GetMapping
    @ResponseBody
    public List<AlbumDTO> getAlbums() {
        return albumService.getAllAlbums();
    }
    
    @GetMapping(value="/{id}")
    @ResponseBody
    public AlbumDTO getAlbum(@PathVariable("id") Long id) {
        return albumService.getAlbum(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AlbumDTO createNewAlbum(@RequestBody AlbumDTO albumDTO){
        return albumService.createNewAlbum(albumDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public AlbumDTO updateAlbum(@PathVariable Long id, @RequestBody AlbumDTO albumDTO){
        return albumService.saveAlbum(id, albumDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAlbum(@PathVariable Long id){
    	albumService.deleteAlbumById(id);
}

}
