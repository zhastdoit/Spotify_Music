package com.hellokoding.account.web;

import com.hellokoding.account.model.*;
import com.hellokoding.account.service.*;
import com.hellokoding.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class UserController {

    private static final Set<String> GENRESET = new HashSet<>(Arrays.asList("pop", "r&b", "jazz", "blues", "country", "classical", "metal", "popular", "rap"));

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private TrackService trackService;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private RecommendService recommendService;


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userForm.setUimage("https://dncache-mauganscorp.netdna-ssl.com/thumbseg/378/378006-bigthumbnail.jpg");
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        List<Track> recommendByRecentListen = trackService.recommendByRecentListen(getUidFromSystem());
        List<Long> recommendTrackId = recommendService.getRecommendTrack();
        List<Track> resultRecommend = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            resultRecommend.add(trackService.findById(recommendTrackId.get(i)));
        }
        List<Double> scores = new ArrayList<>();
        resultRecommend.forEach((track) -> {
            Long tid = track.getId();
            scores.add(trackService.getAverageScore(tid).isPresent() ? trackService.getAverageScore(tid).get() :(Double) 0d);
        });
        List<Track> history = trackService.getListenedTracksByUid(getUidFromSystem());
        List<Track> followingHistory = trackService.getFollowingsListenTracksByUid(getUidFromSystem());
        model.addAttribute("scores",scores);
        model.addAttribute("recommendTrack", resultRecommend);
        model.addAttribute("recommendByRecentListen", recommendByRecentListen);
        model.addAttribute("history", history);
        model.addAttribute("followingHistory",followingHistory);
        return "welcome";
    }

    @RequestMapping(value = "/rates", method = RequestMethod.GET)
    public String showMyRateHistory(Model theModel) {
        Long uid = getUidFromSystem();
        List<Rate> myRateList = trackService.getMyRate(uid);
        theModel.addAttribute("rateList", myRateList);
        return "rates";
    }

    @RequestMapping(value = "/followers", method = RequestMethod.GET)
    public String myFollowers(Model theModel) {
        Long uid = getUidFromSystem();
        List<User> followers = userService.getFollowersById(uid);
        theModel.addAttribute("followers", followers);
        return "followers";
    }

    @RequestMapping(value = "/followings", method = RequestMethod.GET)
    public String myFollowings(Model theModel) {
        Long uid = getUidFromSystem();
        List<User> followings = userService.getFollowingsById(uid);
        theModel.addAttribute("followings", followings);
        return "followings";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String mySearch(@RequestParam("search") String searchContent, Model theModel) {

        List<Album> getAlbumByKeyword = new ArrayList<>();
        List<Track> getTrackByKeyword = new ArrayList<>();
        List<Track> getTrackByGenre = new ArrayList<>();
        List<Artist> getArtistByKeyword = new ArrayList<>();
        boolean hasArtistList = true;
        boolean hasAlbumList = true;
        boolean hasTrackGenreList = false;
        boolean hasTrackList = true;

        if (GENRESET.contains(searchContent.toLowerCase())) {
            getTrackByGenre = trackService.getTracksByGenreKeyword(searchContent);
            hasTrackGenreList = true;
            theModel.addAttribute("hasTrackGenreList", hasTrackGenreList);
            theModel.addAttribute("trackGenreResult", getTrackByGenre);
        }
        else {
            theModel.addAttribute("hasTrackGenreList", hasTrackGenreList);
        }
        getArtistByKeyword = artistService.getArtistByKeyword(searchContent);
        getTrackByKeyword = trackService.getTrackByKeyword(searchContent);
        getAlbumByKeyword = albumService.getAlbumByKeyword(searchContent);
        if (getTrackByGenre.size() == 0
                && getArtistByKeyword.size() == 0
                && getTrackByKeyword.size() == 0
                && getAlbumByKeyword.size() == 0) {
            return "not-found-page";
        }
        else {
            if (getArtistByKeyword.size() != 0) {
                theModel.addAttribute("hasArtistList", hasArtistList);
                theModel.addAttribute("aritstResult", getArtistByKeyword);
            }
            if (getArtistByKeyword.size() == 0){
                hasArtistList = false;
                theModel.addAttribute("hasArtistList", hasArtistList);
            }
            if (getAlbumByKeyword.size() != 0) {
                theModel.addAttribute("hasAlbumList", hasAlbumList);
                theModel.addAttribute("albumResult", getAlbumByKeyword);
            }
            if (getAlbumByKeyword.size() == 0) {
                hasAlbumList = false;
                theModel.addAttribute("hasAlbumList", hasAlbumList);
            }
            if (getTrackByKeyword.size() != 0) {
                theModel.addAttribute("hasTrackList", hasTrackList);
                theModel.addAttribute("trackResult", getTrackByKeyword);
            }
            if (getTrackByKeyword.size() == 0) {
                hasTrackList = false;
                theModel.addAttribute("hasTrackList", hasTrackList);
            }
            return "result";
        }
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userProfile(@PathVariable("id") Long fid, Model theModel) {
        User user = userService.findById(fid);
        boolean isFollowing = userService.isFollowing(getUidFromSystem(), fid);
        List<Playlist> playlists = playlistService.getUserPlaylist(fid);
        List<User> followings = userService.getFollowingsById(user.getId());
        List<User> followers = userService.getFollowersById(user.getId());
        theModel.addAttribute("user", user);
        theModel.addAttribute("isFollowing", isFollowing);
        theModel.addAttribute("playlists",playlists);
        theModel.addAttribute("numberOfFollowings", followings.size());
        theModel.addAttribute("numberOfFollowers", followers.size());
        return "user-profile";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String updateFollow(@PathVariable("id") Long fid, @RequestParam("followStatus") boolean followStatus, Model theModel) {
        Long uid = getUidFromSystem();
        User user = userService.findById(fid);
        boolean isFollowing = userService.isFollowing(uid, fid);
        List<Playlist> playlists = playlistService.getUserPlaylist(fid);
        List<User> followings = userService.getFollowingsById(user.getId());
        List<User> followers = userService.getFollowersById(user.getId());
        if(followStatus) {
            userService.saveFollow(uid, fid);
        } else {
            userService.deleteFollow(uid, fid);
        }
        theModel.addAttribute("user", user);
        theModel.addAttribute("isFollowing", isFollowing);
        theModel.addAttribute("playlists",playlists);
        theModel.addAttribute("numberOfFollowings", followings.size());
        theModel.addAttribute("numberOfFollowers", followers.size());
        return "redirect:/user/"+fid;
    }
    @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
    public String myProfile(Model theModel) {
        User user = userService.findById(getUidFromSystem());
        List<User> followings = userService.getFollowingsById(user.getId());
        List<User> followers = userService.getFollowersById(user.getId());
        theModel.addAttribute("user", user);
        theModel.addAttribute("numberOfFollowings", followings.size());
        theModel.addAttribute("numberOfFollowers", followers.size());
        return "user-myprofile";
    }

    private Long getUidFromSystem() {
        String username = FindUsername.findLoggedInUsername();
        User user = userService.findByUsername(username);
        return user.getId();
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorPage(Model theModel) {
        return "not-found-page";
    }
}
