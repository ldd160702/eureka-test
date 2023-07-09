package com.example.samsung.service;


import com.example.samsung.model.Device;
import com.example.samsung.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository repo;
    public List<Device> getDevices() {
        List<Device> devices = new ArrayList<>();
        Iterable<Device> iterable = repo.findAll();
        iterable.forEach(devices::add);
        return devices;
    }

    public Device getDeviceById(int id) {
        Device device = repo.findById(id).get();
        return device;
    }

    public void addDevice(Device device) {
        repo.save(device);
    }

    public void updateDevice(Device device, int id) {
        Device temp = repo.findById(id).get();
        if (device.getName() != null) temp.setName(device.getName());
        if (device.getType() != null) temp.setType(device.getType());
        repo.save(temp);
    }

    public void updateDevice(Device device) {
        repo.save(device);
    }

    public void deleteDevice(int id) {
        repo.deleteById(id);
    }
}
