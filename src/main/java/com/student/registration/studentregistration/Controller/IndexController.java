package com.student.registration.studentregistration.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

//*this controller is actually overridden by the WebConfig bean*
//I had initially intended to serve the react app via this controller, like you would with a thymeleaf view
//but I couldn't manage to get the ModelAndView object to forward index.html in the static folder (the react app)
@Controller
public class IndexController {

    @GetMapping("")
    public ModelAndView sendReactApp() {

        return new ModelAndView("index");
    }
}
