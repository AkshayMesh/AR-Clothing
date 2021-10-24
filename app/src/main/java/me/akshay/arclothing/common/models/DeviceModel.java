package me.akshay.arclothing.common.models;

import androidx.annotation.NonNull;

public class DeviceModel {
    public String OSNAME = System.getProperty("os.name");
    public String OSVERSION = System.getProperty("os.version");
    public String RELEASE = android.os.Build.VERSION.RELEASE;
    public String DEVICE = android.os.Build.DEVICE;
    public String MODEL = android.os.Build.MODEL;
    public String PRODUCT = android.os.Build.PRODUCT;
    public String BRAND = android.os.Build.BRAND;
    public String DISPLAY = android.os.Build.DISPLAY;
    public String HARDWARE = android.os.Build.HARDWARE;
    public String ID = android.os.Build.ID;
    public String MANUFACTURER = android.os.Build.MANUFACTURER;
    public String HOST = android.os.Build.HOST;

    @NonNull
    @Override
    public String toString() {
        return "DeviceModel{" +
                "OSNAME='" + OSNAME + '\'' +
                ", OSVERSION='" + OSVERSION + '\'' +
                ", RELEASE='" + RELEASE + '\'' +
                ", DEVICE='" + DEVICE + '\'' +
                ", MODEL='" + MODEL + '\'' +
                ", PRODUCT='" + PRODUCT + '\'' +
                ", BRAND='" + BRAND + '\'' +
                ", DISPLAY='" + DISPLAY + '\'' +
                ", HARDWARE='" + HARDWARE + '\'' +
                ", ID='" + ID + '\'' +
                ", MANUFACTURER='" + MANUFACTURER + '\'' +
                ", HOST='" + HOST + '\'' +
                '}';
    }
}
