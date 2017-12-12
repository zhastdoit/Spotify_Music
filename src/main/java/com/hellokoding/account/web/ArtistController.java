package com.hellokoding.account.web;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = {"/artist"}, method = RequestMethod.GET)
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String getAllArtist(Model theModel) {
        List<Artist> artistList = artistService.getArtistList();
        theModel.addAttribute("artist", artistList);
        return "artist-list";
    }

    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getArtistDetails(@PathVariable("id") Long id, Model theModel) {
        Artist artist = artistService.getArtistById(id);
        List<Track> artistTracks = artistService.getArtistTrackList(artist.getAname());
        theModel.addAttribute("track", artistTracks);
        return "artist-details";
    }



}
