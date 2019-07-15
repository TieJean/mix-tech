package com.example.cs564.controller;

import com.example.cs564.dao.PlaylistRepo;
import com.example.cs564.entity.PlaylistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    private PlaylistRepo playlistRepo;

    @Autowired
    public LibraryController(PlaylistRepo playlistRepo) {
        this.playlistRepo = playlistRepo;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PlaylistEntity> getAll() {
        return playlistRepo.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PlaylistEntity playlistEntity) {
        playlistRepo.save(playlistEntity);
    }
}
