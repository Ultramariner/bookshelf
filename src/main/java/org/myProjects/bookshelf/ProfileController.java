package org.myProjects.bookshelf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController {

    @GetMapping()
    public String get() {
        System.out.println("---GET---");
        return "profile";
    }

}