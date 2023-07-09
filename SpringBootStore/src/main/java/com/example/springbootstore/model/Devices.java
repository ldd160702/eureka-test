package com.example.springbootstore.model;

import java.util.List;

public class Devices {
    private List<Device> devices;
    private String brandName;

    public Devices() {
    }

    public Devices(List<Device> listDevices) {
        this.devices = listDevices;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public Devices(List<Device> listDevices, String brandName) {
        this.devices = listDevices;
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "devices=" + devices +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
