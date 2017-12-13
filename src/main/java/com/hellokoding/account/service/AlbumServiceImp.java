package com.hellokoding.account.service;

import com.hellokoding.account.model.Album;
import com.hellokoding.account.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImp implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAlbumList() {
        return albumRepository.findAll();
    }

}
