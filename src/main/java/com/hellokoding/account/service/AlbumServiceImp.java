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

    @Override
    public List<Album> getAlbumByKeyword(String keyword) {
        return albumRepository.getTop10AlbumsByAtitleContains(keyword);
    }

    @Override
    public Album getAlbumWithAlid(Long alid) {
        return albumRepository.getAlbumByAlid(alid);
    }

    @Override
    public List<Album> getAllByIdBetween(Long a, Long b) {
        return albumRepository.getAllByAlidBetween(a, b);
    }
}
