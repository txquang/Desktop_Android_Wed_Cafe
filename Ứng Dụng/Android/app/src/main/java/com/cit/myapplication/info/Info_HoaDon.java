package com.cit.myapplication.info;

public class Info_HoaDon
{
    private String MaSanPham, TenSanPham, MaNhom;
    private int SoLuong, DonGia, ThanhTien;

    public Info_HoaDon(String maSanPham, String tenSanPham, int soLuong, int donGia, int thanhTien, String maNhom) {
        MaSanPham = maSanPham;
        TenSanPham = tenSanPham;
        SoLuong = soLuong;
        DonGia = donGia;
        ThanhTien = thanhTien;
        MaNhom = maNhom;
    }

    public String getMaNhom() {
        return MaNhom;
    }

    public void setMaNhom(String maNhom) {
        MaNhom = maNhom;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        MaSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        TenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int donGia) {
        DonGia = donGia;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int thanhTien) {
        ThanhTien = thanhTien;
    }
}
