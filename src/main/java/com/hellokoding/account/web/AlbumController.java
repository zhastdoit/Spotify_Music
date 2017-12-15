package com.hellokoding.account.web;

import com.hellokoding.account.model.Album;
import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = {"/album"}, method = RequestMethod.GET)
public class AlbumController {
    private final int ITEM_PER_PAGE = 15;
    @Autowired
    private AlbumService albumService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrackService trackService;

    @Autowired
    private PlaylistService playlistService;

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getAlbumById(@PathVariable("id") Long id, Model theModel) {
        Album theAlbum = albumService.getAlbumWithAlid(id);
        List<Track> albumTrack = trackService.getTrackByAlbum(id);
        List<Double> scores = new ArrayList<>();
        albumTrack.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        List<Playlist> playlists = playlistService.getUserPlaylist(getUidFromSystem());
        theModel.addAttribute("playlists",playlists);
        theModel.addAttribute("trackList", albumTrack);
        theModel.addAttribute("scores", scores);
        theModel.addAttribute("album", theAlbum);
        return "album-details";
    }

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showAlbumFirstPage(Model theModel) {
        List<Album> theAlbum = albumService.getAllByIdBetween(Long.valueOf(0),Long.valueOf(ITEM_PER_PAGE-1));
        theModel.addAttribute("notFirstPage", false);
        theModel.addAttribute("page", 1);
        theModel.addAttribute("albums", theAlbum);
        return "albums";
    }

    @RequestMapping(value = {"/all-page"}, method = RequestMethod.POST)
    public String showAlbumInRange(@RequestParam("next") String next, @RequestParam("page") String page, Model theModel) {
        int currentPage = Integer.parseInt(page)-1;
        int itemFromIndex =currentPage*ITEM_PER_PAGE;
        boolean isNext = Boolean.parseBoolean(next);
        List<Album> allAlbumInRange = new ArrayList<>();
        if(isNext) {
            allAlbumInRange = albumService.getAllByIdBetween(Long.valueOf(itemFromIndex+ITEM_PER_PAGE),Long.valueOf(itemFromIndex+ITEM_PER_PAGE*2));
            currentPage = currentPage+1;
        } else {
            allAlbumInRange = albumService.getAllByIdBetween(Long.valueOf(itemFromIndex-ITEM_PER_PAGE),Long.valueOf(itemFromIndex));
            currentPage = currentPage-1;
        }
        if(allAlbumInRange.size()==0) {
            allAlbumInRange = albumService.getAllByIdBetween(Long.valueOf(itemFromIndex),Long.valueOf(itemFromIndex+ITEM_PER_PAGE-1));
            currentPage = Integer.parseInt(page);
        }
        theModel.addAttribute("notFirstPage", currentPage != 0);
        theModel.addAttribute("page", currentPage+1);
        theModel.addAttribute("albums", allAlbumInRange);
        return "albums";
    }

    private Long getUidFromSystem() {
        String username = FindUsername.findLoggedInUsername();
        User user = userService.findByUsername(username);
        return user.getId();
    }
}
