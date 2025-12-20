package com.mysite.sbb.music;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public List<Music> list() {
        return musicRepository.findAll();
    }

    public Music create(Music music) {
        return musicRepository.save(music);
    }

    public Music detail(Long id) {
        return musicRepository.findById(id).orElse(null);
    }
}