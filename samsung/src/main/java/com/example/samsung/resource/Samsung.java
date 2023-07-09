package com.example.samsung.resource;

import com.example.samsung.model.Device;
import com.example.samsung.model.Devices;
import com.example.samsung.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/devices/{id}")
    public Device getDevice(int id) {
        return service.getDeviceById(id);
    }

    @RequestMapping(value = "/devices", method=RequestMethod.POST)
    public void addDevice(@RequestBody Device device) {
        service.addDevice(device);
    }

    @RequestMapping(value = "/devices/{id}",method=RequestMethod.PUT)
    public void updateDevice(@RequestBody Device device, @PathVariable int id) {
        service.updateDevice(device, id);
    }

    @RequestMapping(value = "/devices/{id}",method=RequestMethod.DELETE)
    public void deleteDevice(@PathVariable int id) {
        service.deleteDevice(id);
    }
}
