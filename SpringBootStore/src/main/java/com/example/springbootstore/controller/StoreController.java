package com.example.springbootstore.controller;

import com.example.springbootstore.model.Devices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final LoadBalancerClient loadBalancer;
    private ModelAndView modelAndView;

    @Autowired
    public StoreController(LoadBalancerClient loadBalancer) {
        this.loadBalancer = loadBalancer;
    }


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/{brandName}")
    public ModelAndView brand(@PathVariable String brandName) {
        Devices result;
        String url;
        RestTemplate restTemplate = new RestTemplate();
        modelAndView = new ModelAndView("viewDevices");
        switch (brandName){
            case "samsung":
                url = loadBalancer.choose("SAMSUNG").getUri().toString();
                result = restTemplate.getForObject(url + "/samsung/devices", Devices.class);
                modelAndView.addObject("devices", result);
                return modelAndView;
            case "apple":
                url = loadBalancer.choose("APPLE").getUri().toString();
                result = restTemplate.getForObject(url + "/apple/devices", Devices.class);
                modelAndView.addObject("devices", result);
                return modelAndView;
            default:
                modelAndView = new ModelAndView("redirect:/error");
                return modelAndView;
        }

    }

}
