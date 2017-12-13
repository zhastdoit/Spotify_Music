package com.hellokoding.account.web;

import com.hellokoding.account.model.Album;
import com.hellokoding.account.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/album"}, method = RequestMethod.GET)
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showPlaylist(Model theModel) {
        List<Album> theAlbum = albumService.getAlbumList();
        theModel.addAttribute("albums", theAlbum);
        return "albums";
    }

//    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
//    public String getTrackListByPlaylist(@PathVariable("id") Long id, Model theModel) {
//
//        List<Track> playlistTrack = trackService.getTrackByPlaylist(id);
//        theModel.addAttribute("trackList", playlistTrack);
//        List<Double> scores = new ArrayList<>();
//        playlistTrack.forEach((track) -> {
//            Long tid = track.getId();
//            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
//        });
//        theModel.addAttribute("trackList", playlistTrack);
//        theModel.addAttribute("scores", scores);
//        return "tracks";
//    }

}
