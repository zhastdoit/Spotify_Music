package com.hellokoding.account.web;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.ArtistService;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"/artist"}, method = RequestMethod.GET)
public class ArtistController {

    @Autowired
    private ArtistService artistService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String getAllArtist(Model theModel) {
        List<Artist> artistList = artistService.getArtistList();
        theModel.addAttribute("artist", artistList);
        return "artist-list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getArtistDetails(@PathVariable("id") Long aid, Model theModel) {
        Artist artist = artistService.getArtistById(aid);
        List<Track> artistTracks = artistService.getArtistTrackList(artist.getAname());
            boolean isLiking = userService.isLiking(getUidFromSystem(), aid);
        List<User> fans = userService.getFansById(aid);
        theModel.addAttribute("isLiking", isLiking);
        theModel.addAttribute("numberOfFans", fans.size());
        theModel.addAttribute("artist", artist);
        theModel.addAttribute("track", artistTracks);
        return "artist-details";
    }

    @RequestMapping(value = "/{id}/new", method = RequestMethod.POST)
    public String updateLike(@PathVariable("id") Long aid, @RequestParam("likeStatus") boolean likeStatus, Model theModel) {
        Long uid = getUidFromSystem();
        Artist artist = artistService.getArtistById(aid);
        List<Track> artistTracks = artistService.getArtistTrackList(artist.getAname());
        List<User> fans = userService.getFansById(aid);
        Boolean isLiking = userService.isLiking(uid, aid);
        if(likeStatus) {
            userService.saveLike(uid, aid);
        } else {
            userService.deleteLike(uid, aid);
        }
        theModel.addAttribute("artist", artist);
        theModel.addAttribute("isLiking", isLiking);
        theModel.addAttribute("numberOfFans", fans.size());
        theModel.addAttribute("track", artistTracks);
        return "redirect:/artist/"+aid;
    }

    private Long getUidFromSystem() {
        String username = FindUsername.findLoggedInUsername();
        User user = userService.findByUsername(username);
        return user.getId();
    }
}
