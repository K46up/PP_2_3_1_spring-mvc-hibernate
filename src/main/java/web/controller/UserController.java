package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/people")                                                                                 //работает
        public String printListUsers(Model model) {
        model.addAttribute("people", userService.getAll());
        return "people";
    }

    @GetMapping("/delete_user")                                                                            //работает
    public String deleteUserById(@RequestParam(name = "id") Long id) {
        userService.delete(id);
        return "redirect:/people";
    }
    @GetMapping("/addUser")                                                                                //работает
    public String formAddUser(@ModelAttribute("user") User user) {

        return "addUser";
    }

    @PostMapping("/addUser")                                                                               //работает
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/people";
    }

    @GetMapping("/user")                                                                                   //работает
    public String showSingleUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }

    @PostMapping("/update")                                                                                //работает
    public String update(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/people";
    }

}
