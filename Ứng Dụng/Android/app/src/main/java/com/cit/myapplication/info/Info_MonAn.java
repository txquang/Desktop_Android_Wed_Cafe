package com.cit.myapplication.info;

public class Info_MonAn {
    private String MaSP, TenSP, MaDVT, SLDK, GTDK, MaNhom, TenNhom;

    public Info_MonAn(String maSP, String tenSP, String maDVT, String SLDK, String GTDK, String maNhom, String tenNhom) {
        MaSP = maSP;
        TenSP = tenSP;
        MaDVT = maDVT;
        this.SLDK = SLDK;
        this.GTDK = GTDK;
        MaNhom = maNhom;
        TenNhom = tenNhom;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String maSP) {
        MaSP = maSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String tenSP) {
        TenSP = tenSP;
    }

    public String getMaDVT() {
        return MaDVT;
    }

    public void setMaDVT(String maDVT) {
        MaDVT = maDVT;
    }

    public String getSLDK() {
        return SLDK;
    }

    public void setSLDK(String SLDK) {
        this.SLDK = SLDK;
    }

    public String getGTDK() {
        return GTDK;
    }

    public void setGTDK(String GTDK) {
        this.GTDK = GTDK;
    }

    public String getMaNhom() {
        return MaNhom;
    }

    public void setMaNhom(String maNhom) {
        MaNhom = maNhom;
    }

    public String getTenNhom() {
        return TenNhom;
    }

    public void setTenNhom(String tenNhom) {
        TenNhom = tenNhom;
    }
}
