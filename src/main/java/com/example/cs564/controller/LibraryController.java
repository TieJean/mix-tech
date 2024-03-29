package com.example.cs564.controller;

import com.example.cs564.dao.PlaylistRepo;
import com.example.cs564.entity.PlaylistEntity;
import com.example.cs564.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/library")
public class LibraryController {
    @Autowired
    private PlaylistService playlistService;

//    @Autowired
//    public LibraryController(PlaylistRepo playlistRepo) {
//        this.playlistRepo = playlistRepo;
//    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Page<PlaylistEntity> getAllByPage(@RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "size", defaultValue = "10") int size) {
        return playlistService.getAllByPage(page, size);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(@RequestBody PlaylistEntity playlistEntity) {
        playlistService.create(playlistEntity);
    }

    @RequestMapping(value = "/delete/{pid}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long pid) {
        playlistService.remove(pid);
    }
}
