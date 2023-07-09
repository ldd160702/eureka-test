package com.example.samsung.resource;

import com.example.samsung.model.Device;
import com.example.samsung.model.Devices;
import com.example.samsung.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/samsung")
public class Samsung {
    @Autowired
    private DeviceService service;

    @RequestMapping("/devices")
    public Devices getDevices() {
        List<Device> list = service.getDevices();
        Devices devices = new Devices(list);
        return devices;
    }
}
