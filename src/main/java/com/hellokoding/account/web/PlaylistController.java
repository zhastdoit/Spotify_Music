package com.hellokoding.account.web;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.PlaylistService;
import com.hellokoding.account.service.TrackService;
import com.hellokoding.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = {"/playlist"}, method = RequestMethod.GET)
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showPlaylist(Model theModel) {
        String username = FindUsername.findLoggedInUsername();
        User theUser = userService.findByUsername(username);
        List<Playlist> thePlaylist = playlistService.getUserPlaylist(theUser.getId());
        theModel.addAttribute("playlist", thePlaylist);
        return "playlists";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String newPlaylist(@RequestParam("playlistName") String playlistName, @RequestParam("options") boolean isPublic, Model theModel) {
        String username = FindUsername.findLoggedInUsername();
        User theUser = userService.findByUsername(username);
        Playlist playlist = new Playlist(playlistName, isPublic,theUser.getId());
        playlistService.savePlaylist(playlist);
        return "redirect:/playlist/all";
    }

    @RequestMapping(value = {"/newplaylist"}, method = RequestMethod.GET)
    public String newPlaylist(Model theModel) {
        return "playlist-add";
    }


    @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    public String getTrackListByPlaylist(@PathVariable("id") Long id, Model theModel) {

        List<Track> playlistTrack = trackService.getTrackByPlaylist(id);
        List<Double> scores = new ArrayList<>();
        playlistTrack.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        theModel.addAttribute("trackList", playlistTrack);
        theModel.addAttribute("scores", scores);
        return "tracks";
    }

}
