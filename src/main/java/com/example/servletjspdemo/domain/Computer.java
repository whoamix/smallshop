package com.example.servletjspdemo.domain;

public class Computer {

    private String model;
    private int ram;
    private String cpu;
    private int hdd;
    private String gpu;
    private double price;
    private int amout;

    public Computer () {

    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public Computer(String model, int ram, String cpu, int hdd, String gpu, double price, int amout) {
        this.model = model;
        this.ram = ram;
        this.cpu = cpu;
        this.hdd = hdd;
        this.gpu = gpu;
        this.price = price;
        this.amout = amout;

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void incrementAmount() {
        this.amout++;
    }
    public int getAmount() {
        return amout;
    }
    public void decreaseAmount() {
        amout--;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        if (ram != computer.ram) return false;
        if (hdd != computer.hdd) return false;
        if (model != null ? !model.equals(computer.model) : computer.model != null) return false;
        if (cpu != null ? !cpu.equals(computer.cpu) : computer.cpu != null) return false;
        return gpu != null ? gpu.equals(computer.gpu) : computer.gpu == null;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = 31 * result + ram;
        result = 31 * result + (cpu != null ? cpu.hashCode() : 0);
        result = 31 * result + hdd;
        result = 31 * result + (gpu != null ? gpu.hashCode() : 0);
        return result;
    }
}
