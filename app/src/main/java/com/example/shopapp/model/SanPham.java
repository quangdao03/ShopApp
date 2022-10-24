package com.example.shopapp.model;

public class SanPham {
    private int anh;
    private String name;
    private String gia;

    public SanPham(int anh, String name, String gia) {
        this.anh = anh;
        this.name = name;
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "anh=" + anh +
                ", name='" + name + '\'' +
                ", gia='" + gia + '\'' +
                '}';
    }
}
