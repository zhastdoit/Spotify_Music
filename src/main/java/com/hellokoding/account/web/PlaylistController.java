package com.hellokoding.account.web;

import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.User;
import com.hellokoding.account.repository.UserRepository;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = {"/playlist"}, method = RequestMethod.GET)
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showPlaylist(Model theModel) {
        String username = FindUsername.findLoggedInUsername();
        User theUser = userRepository.findByUsername(username);
        List<Playlist> thePlaylist = playlistService.getUserPlaylist(theUser.getId());
        theModel.addAttribute("playlist", thePlaylist);
        return "playlists";
    }

    @RequestMapping(value = {"/newplaylist"}, method = RequestMethod.GET)
    public String newPlaylist(Model theModel) {

        return "addPlaylist";
    }

}
