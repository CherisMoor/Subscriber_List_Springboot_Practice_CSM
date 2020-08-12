package com.wincsm.subscriberlist.Subscribers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Designates this class as a Controller
public class SubscriberController {

    @Autowired // annotation that tells Spring to connect these two things (Load and
               // instantiate this object and connect it)
    private SubscriberRepository subscriberRepository;

    @GetMapping // Tells our app what template to return at a specific URL
    public String index(Subscriber subscriber) {
        return "subscriber/index";
    }

    private Subscriber subscriber;

    // This takes the data entered in the form and adds it to the database
    // POSTs the data and then displays a new template called "result"
    @PostMapping
    public String addNewSubscriber(Subscriber subscriber, Model model) {
        subscriberRepository.save(new Subscriber(subscriber.getFirstName(), subscriber.getLastName(),
                subscriber.getUserName(), subscriber.getSignedUp()));
        model.addAttribute("firstName", subscriber.getFirstName());
        model.addAttribute("lastName", subscriber.getLastName());
        model.addAttribute("userName", subscriber.getUserName());

        return "subscriber/result";
    }
}