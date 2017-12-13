package com.hellokoding.account.web;

import com.hellokoding.account.model.Rate;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String showFollowers(Model theModel) {
        Long uid = getUidFromSystem();
        List<User> followers = userService.getFollowersById(uid);
        theModel.addAttribute("followers", followers);
        return "followers";
    }

    @RequestMapping(value = "/followings", method = RequestMethod.GET)
    public String showFollowings(Model theModel) {
        Long uid = getUidFromSystem();
        List<User> followings = userService.getFollowingsById(uid);
        theModel.addAttribute("followings", followings);
        return "followings";
    }

    private Long getUidFromSystem() {
        String username = FindUsername.findLoggedInUsername();
        User user = userService.findByUsername(username);
        Long uid = user.getId();
        return uid;
    }
}
