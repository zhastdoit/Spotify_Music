package com.hellokoding.account.web;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.TrackInPlaylist;
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
        Playlist thePlaylist = playlistService.getPlaylistWithPid(id);
        List<Track> playlistTrack = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        String alert = "";
        if(!thePlaylist.getUid().equals(getUidFromSystem()) && !thePlaylist.getCanSee()) {
            alert = "&#128275; This is a private playlist";
        } else {
            playlistTrack = trackService.getTrackByPlaylist(id);
            playlistTrack.forEach((track) -> {
                Long tid = track.getId();
                scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() : (Double) 0d);
            });
        }
        theModel.addAttribute("playlist", thePlaylist);
        theModel.addAttribute("owner",userService.findById(thePlaylist.getUid()));
        theModel.addAttribute("trackList", playlistTrack);
        theModel.addAttribute("scores", scores);
        theModel.addAttribute("alert", alert);
        return "playlist-details";
    }

    @RequestMapping(value = {"/{pid}/remove/{tid}"}, method = RequestMethod.GET)
    public String removeTrackInPlaylist(@PathVariable("pid") Long pid, @PathVariable("tid") Long tid, Model theModel) {
        playlistService.removeTrackInPlaylist(pid,tid);
        return "redirect:/playlist/"+pid;
    }

    @RequestMapping(value = {"/{pid}/addToPlaylist/{tid}"}, method = RequestMethod.GET)
    public String getTrackListByPlaylist(@PathVariable("pid") Long pid, @PathVariable("tid") Long tid, Model theModel) {
        Playlist playlist = playlistService.getPlaylistWithPid(pid);
        TrackInPlaylist trackInPlaylist = new TrackInPlaylist(pid,tid);
        playlistService.saveTrackInPlaylist(trackInPlaylist);
        String alert = "";
        List<Track> playlistTrack = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        if(!playlist.getUid().equals(getUidFromSystem())) {
            alert = "&#128275; This is a private playlist";
        } else {
            playlistTrack = trackService.getTrackByPlaylist(pid);
            playlistTrack.forEach((track) -> {
                Long id = track.getId();
                scores.add(trackService.getAverageScore(id).isPresent() ? trackService.getAverageScore(id).get() : (Double) 0d);
            });
        }
        theModel.addAttribute("playlist", playlist);
        theModel.addAttribute("owner",userService.findById(playlist.getUid()));
        theModel.addAttribute("trackList", playlistTrack);
        theModel.addAttribute("scores", scores);
        theModel.addAttribute("alert", alert);
        return "redirect:/playlist/"+pid.toString();
    }

    private Long getUidFromSystem() {
        String username = FindUsername.findLoggedInUsername();
        User user = userService.findByUsername(username);
        return user.getId();
    }

    @RequestMapping(value = {"/remove/{pid}"}, method = RequestMethod.GET)
    public String removePlaylist(@PathVariable("pid") Long pid, Model theModel) {
        playlistService.removePlaylist(pid);
        return "redirect:/playlist/all";
    }
}
