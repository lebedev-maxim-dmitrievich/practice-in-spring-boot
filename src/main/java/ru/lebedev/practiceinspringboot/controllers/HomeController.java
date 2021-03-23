package ru.lebedev.practiceinspringboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.lebedev.practiceinspringboot.models.Users;
import ru.lebedev.practiceinspringboot.repository.UsersRepository;

@Controller
public class HomeController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Users> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "home";
    }

    @PostMapping("/")
    public String homeAddUser(@RequestParam String login, @RequestParam String password, Model model) {
        Users user = new Users();
        user.setLogin(login);
        user.setPassword(password);
        usersRepository.save(user);
        return "redirect:/";
    }

}
