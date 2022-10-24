package com.example.shopapp.model;

public class DanhMuc {
    private int anh;
    private String name;

    public DanhMuc(int anh, String name) {
        this.anh = anh;
        this.name = name;
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

    @Override
    public String toString() {
        return "DanhMuc{" +
                "anh=" + anh +
                ", name='" + name + '\'' +
                '}';
    }
}
