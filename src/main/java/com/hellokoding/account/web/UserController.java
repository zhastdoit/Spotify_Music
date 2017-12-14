package com.hellokoding.account.web;

import com.hellokoding.account.model.Follow;
import com.hellokoding.account.model.Rate;
import com.hellokoding.account.model.Track;
import com.hellokoding.account.model.User;
import com.hellokoding.account.service.FindUsername;
import com.hellokoding.account.service.SecurityService;
import com.hellokoding.account.service.TrackService;
import com.hellokoding.account.service.UserService;
import com.hellokoding.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private TrackService trackService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
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
        model.addAttribute("recommendByRecentListen", recommendByRecentListen);
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

    @RequestMapping(value = "/Search", method = RequestMethod.GET)
    public String mySearch(@RequestParam("Search") String searchContent, Model theModel) {
        boolean isNumeric = true;
        try {
            int num = Integer.parseInt(searchContent);

        } catch (NumberFormatException nfe) {
            isNumeric = false;
        }
        if (isNumeric) {

        } else {

        }
        return null;
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String userProfile(@PathVariable("id") Long fid, Model theModel) {
        User user = userService.findById(fid);
        boolean isFollowing = userService.isFollowing(getUidFromSystem(), fid);
        List<User> followings = userService.getFollowingsById(user.getId());
        List<User> followers = userService.getFollowersById(user.getId());
        theModel.addAttribute("user", user);
        theModel.addAttribute("isFollowing", isFollowing);
        theModel.addAttribute("numberOfFollowings", followings.size());
        theModel.addAttribute("numberOfFollowers", followers.size());
        return "user-profile";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String updateFollow(@PathVariable("id") Long fid, @RequestParam("followStatus") boolean followStatus, Model theModel) {
        Long uid = getUidFromSystem();
        User user = userService.findById(fid);
        boolean isFollowing = userService.isFollowing(uid, fid);
        List<User> followings = userService.getFollowingsById(user.getId());
        List<User> followers = userService.getFollowersById(user.getId());
        if(followStatus) {
            userService.saveFollow(uid, fid);
        } else {
            userService.deleteFollow(uid, fid);
        }
        theModel.addAttribute("user", user);
        theModel.addAttribute("isFollowing", isFollowing);
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
}
