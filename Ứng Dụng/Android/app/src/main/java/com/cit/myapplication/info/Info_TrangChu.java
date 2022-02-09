package com.cit.myapplication.info;

public class Info_TrangChu
{
    private String MaBan, MaKhuVuc, TenBan, TrangThai;
    public Info_TrangChu(String maBan, String maKhuVuc, String tenBan, String trangThai) {
        MaBan = maBan;
        MaKhuVuc = maKhuVuc;
        TenBan = tenBan;
        TrangThai = trangThai;
    }

    public String getMaBan() {
        return MaBan;
    }

    public void setMaBan(String maBan) {
        MaBan = maBan;
    }

    public String getMaKhuVuc() {
        return MaKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        MaKhuVuc = maKhuVuc;
    }

    public String getTenBan() {
        return TenBan;
    }

    public void setTenBan(String tenBan) {
        TenBan = tenBan;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }



}
