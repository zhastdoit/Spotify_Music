package com.hellokoding.account.web;

import com.hellokoding.account.model.Artist;
import com.hellokoding.account.model.Playlist;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.ArtistService;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.TrackService;
import com.hellokoding.account.service.PlaylistService;
import com.hellokoding.account.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/artist"}, method = RequestMethod.GET)
public class ArtistController {

    private final int ITEM_PER_PAGE = 15;

    @Autowired
    private ArtistService artistService;
    @Autowired
    private UserService userService;
    @Autowired
    private TrackService trackService;
    @Autowired
    private PlaylistService playlistService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getArtistDetails(@PathVariable("id") Long aid, Model theModel) {
        Artist artist = artistService.getArtistById(aid);
        List<Playlist> playlists = playlistService.getUserPlaylist(getUidFromSystem());
        List<Track> artistTracks = artistService.getArtistTrackList(artist.getAname());
            boolean isLiking = userService.isLiking(getUidFromSystem(), aid);
        List<User> fans = userService.getFansById(aid);
        List<Double> scores = new ArrayList<>();
        artistTracks.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        theModel.addAttribute("scores", scores);
        theModel.addAttribute("playlists",playlists);
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

    @RequestMapping(value = {"/all"}, method = RequestMethod.GET)
    public String showArtistsFirstPage(Model theModel) {
        List<Artist> artistList = artistService.obtainArtistsByIdRangeFrom(Long.valueOf(0),Long.valueOf(ITEM_PER_PAGE-1));
        List<Integer> numberOfFans = new ArrayList<>();
        artistList.forEach((artist) -> {
            numberOfFans.add(userService.getFansById(artist.getId()).size());
        });
        theModel.addAttribute("notFirstPage", false);
        theModel.addAttribute("page", 1);
        theModel.addAttribute("artistList", artistList);
        theModel.addAttribute("numberOfFans", numberOfFans);
        return "artist-list";
    }

    @RequestMapping(value = {"/all-page"}, method = RequestMethod.POST)
    public String showArtistsInRange(@RequestParam("next") String next, @RequestParam("page") String page, Model theModel) {
        int currentPage = Integer.parseInt(page)-1;
        int itemFrom =currentPage * ITEM_PER_PAGE;
        boolean isNext = Boolean.parseBoolean(next);
        List<Artist> artistList = new ArrayList<>();
        if(isNext) {
            artistList = artistService.obtainArtistsByIdRangeFrom(Long.valueOf(itemFrom+ITEM_PER_PAGE+1),Long.valueOf(itemFrom+ITEM_PER_PAGE*2));
            currentPage = currentPage+1;
        } else {
            artistList = artistService.obtainArtistsByIdRangeFrom(Long.valueOf(itemFrom-ITEM_PER_PAGE+1),Long.valueOf(itemFrom));
            currentPage = currentPage-1;
        }
        if(artistList.size()==0) {
            artistList = artistService.obtainArtistsByIdRangeFrom(Long.valueOf(itemFrom+1),Long.valueOf(itemFrom+ITEM_PER_PAGE));
            currentPage = Integer.parseInt(page);
        }

        List<Integer> numberOfFans = new ArrayList<>();
        artistList.forEach((artist) -> {
            numberOfFans.add(userService.getFansById(artist.getId()).size());
        });
        theModel.addAttribute("notFirstPage", currentPage!=0);
        theModel.addAttribute("page", currentPage+1);
        theModel.addAttribute("artistList", artistList);
        theModel.addAttribute("numberOfFans", numberOfFans);
        return "artist-list";
    }

    @RequestMapping(value = {"/favorite"}, method = RequestMethod.GET)
    public String showFavoriteArtists(Model theModel) {
        List<Artist> artistList = artistService.getFavoriteArtistsByUid(getUidFromSystem());
        List<Integer> numberOfFans = new ArrayList<>();
        artistList.forEach((artist) -> {
            numberOfFans.add(userService.getFansById(artist.getId()).size());
        });
        theModel.addAttribute("artistList", artistList);
        theModel.addAttribute("numberOfFans", numberOfFans);
        return "artist-list-all";
    }
}
