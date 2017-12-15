package com.hellokoding.account.service;

import com.hellokoding.account.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album> getAlbumList();
    List<Album> getAlbumByKeyword(String keyword);
    Album getAlbumWithAlid(Long alid);
    List<Album> getAllByIdBetween(Long a, Long b);
}
