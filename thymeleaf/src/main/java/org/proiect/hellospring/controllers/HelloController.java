package org.proiect.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("form")
    //@ResponseBody // - cand spring vede numa un html, cauta fisier in template-uri. mereu face asa, exceptie cu ResponseBody; numa atunci nu cauta
    public String helloForm() {
        return "form"; // form.html; nu are nevoie de html
    }

    // http://localhost:8080/hello?name=nume
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) // pot sa verific daca am GET sau POST request cu 'Inspect element > Network' cand is pe http://localhost:8080/form si dau dupa pe buton
    public String hello(@RequestParam String name, Model model) { // clasa to pass data btw controller and view
        String theGreeting = "serus " + name;
        model.addAttribute("greeting", theGreeting); // primu arg ii parametru dat in html
        return "hello"; // .html
    }

    // /hello/nume
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String theGreeting = "salut " + name;
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Nume 1");
        names.add("Nume 2");
        names.add("Nume 3");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
