package org.proiect.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// toate controllere o sa aiba controller annotations
@Controller
@ResponseBody // in loc sa pun la fiecare metoda separat
@RequestMapping("hello")
public class HelloController {

    // static responses

    /*
    // @GetMapping // handles simple Get requests
    @GetMapping("hello") // merge doar pe http://localhost:8080/hello
    @ResponseBody // tells spring boot that this method will return a static plain text response
    public String hello() {
        return "Hello, Spring!";
    }
     */

    @GetMapping("goodbye") // mergea initial doar pe http://localhost:8080/goodbye dar cu @ReqMap(hello) acuma ii /hello/goodbye
    //@ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // handles request of the form /hello?name=Proiect
    // folosesc valoarea lui 'name' as a parameter
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) // accepts both get and post requests
    // pot sa verific daca am GET sau POST request cu 'Inspect element > Network' cand is pe http://localhost:8080/form si dau dupa pe buton
    //@ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // handles request of the form /hello/Proiect
    // ex: localhost:8080/hello/java1514
    @GetMapping("{name}") // acuma ii /hello/{name}
    //@ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // !!!!!!!!!!!!!!!!!! da cv eroare
    @GetMapping("/form") // /hello/form
    //@ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                // // by default, the form o sa aiba Get request
                // "<form action='hello'>" + // submit a request to /hello
                "<form action='/hello' method='post'>" + // post request
                "<input type='text' name='name'>" + // o sa refoloseasca helloWithQueryParam cred
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
