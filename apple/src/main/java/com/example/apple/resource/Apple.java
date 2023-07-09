package com.example.apple.resource;

import com.example.apple.model.Device;
import com.example.apple.model.Devices;
import com.example.apple.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/apple")
public class Apple {
    @Autowired
    private DeviceService service;

    @RequestMapping("/devices")
    public Devices getDevices() {
        List<Device> devices = service.getDevices();
        return new Devices(devices);
    }
}
