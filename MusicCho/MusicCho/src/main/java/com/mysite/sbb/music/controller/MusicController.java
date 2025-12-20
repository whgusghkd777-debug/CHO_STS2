package com.mysite.sbb.music.controller;

import com.mysite.sbb.music.Music;
import com.mysite.sbb.music.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicController {
    private final MusicService musicService;

    @GetMapping("/music")
    public List<Music> list() {
        return musicService.list();
    }

    @PostMapping("/music")
    public Music create(@RequestBody Music music) {
        return musicService.create(music);
    }

    @GetMapping("/music/{id}")
    public Music detail(@PathVariable Long id) {
        return musicService.detail(id);
    }
}