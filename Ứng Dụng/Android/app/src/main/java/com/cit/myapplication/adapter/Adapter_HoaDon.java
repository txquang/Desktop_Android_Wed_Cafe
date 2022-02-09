package com.cit.myapplication.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cit.myapplication.Activity_HoaDon;
import com.cit.myapplication.R;
import com.cit.myapplication.info.Info_HoaDon;
import com.cit.myapplication.viewhoder.ViewHolder_HoaDon;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter_HoaDon extends RecyclerView.Adapter<ViewHolder_HoaDon>{

    private Context mcontext;
    private List<Info_HoaDon> mData = new ArrayList<>();
    String ip = "192.168.43.8";
    //
    public Adapter_HoaDon(Context mcontext, List<Info_HoaDon> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }
    //
    @NonNull
    @Override
    public ViewHolder_HoaDon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoadon,parent,false);
        ViewHolder_HoaDon viewHolder = new ViewHolder_HoaDon(item);
        return new ViewHolder_HoaDon(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_HoaDon holder, int position) {

        final Info_HoaDon imageModel=mData.get(position);
        ViewHolder_HoaDon imageItemHolder=(ViewHolder_HoaDon) holder;
        imageItemHolder.viewTenSP.setText(imageModel.getTenSanPham());
        //ding dang
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        imageItemHolder.viewGiaBan.setText(decimalFormat.format(imageModel.getDonGia())+".₫");//Gia
        imageItemHolder.viewThanhTien.setText(decimalFormat.format(imageModel.getThanhTien())+".₫");//Gia
        imageItemHolder.viewSoLuong.setText(String.valueOf(imageModel.getSoLuong()));
        //xep anh
        switch(imageModel.getMaNhom()) {
            case "MNCF":
                imageItemHolder.viewAnhSP.setImageResource(R.drawable.ic_ma_cafe1);
                break;
            case "MNNU":
                imageItemHolder.viewAnhSP.setImageResource(R.drawable.ic_ma_nuocuon1);
                break;
            case "MNAU":
                imageItemHolder.viewAnhSP.setImageResource(R.drawable.ic_ma_monan1);
                break;
            default:
                imageItemHolder.viewAnhSP.setImageResource(R.drawable.ic_ma_khac1);
        }

        //sk giu thay doi gia sl
        holder.viewLinear.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onLongClick(View v) {
                final Dialog dialog = new Dialog(mcontext);
                dialog.setTitle("Thông Báo");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.hopthoai);
                Button Huy = dialog.findViewById(R.id.button);
                Button DongY = dialog.findViewById(R.id.button2);
                final TextView textView = dialog.findViewById(R.id.textView3);
                final SeekBar seekBar = dialog.findViewById(R.id.seekBar);
                seekBar.setMax(10);
                seekBar.setMin(1);
                seekBar.setProgress(1);

                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        textView.setText(""+progress);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                DongY.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ///String a = (String) textView.getText();
                        //SL = Integer.parseInt(a.trim());
                        SharedPreferences sharedPref = mcontext.getSharedPreferences("MyPreferences",mcontext.MODE_PRIVATE);
                        String MaSP = imageModel.getMaSanPham().trim();
                        String MaDVT = "";
                        int SoLuong = imageModel.getSoLuong();
                        if( SoLuong >= seekBar.getProgress() )
                            SoLuong = seekBar.getProgress() - SoLuong;
                        else
                            SoLuong = seekBar.getProgress() - SoLuong;
                        int GTDK = (int)imageModel.getDonGia();
                        String MaNV = sharedPref.getString("MaNV", "").trim();
                        String SoBan = sharedPref.getString("SoBan", "").trim();
                        String TenSP = imageModel.getTenSanPham().trim();
                        //Toast.makeText(mcontext,  MaNV, Toast.LENGTH_SHORT).show();
                        ThemSP(MaSP, MaDVT, SoLuong, GTDK, MaNV, SoBan, TenSP);
                        dialog.cancel();
                    }
                });
                Huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
                return false;
            }
        });
        //xoa
        holder.viewXoa.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SharedPreferences sharedPref = mcontext.getSharedPreferences("MyPreferences",mcontext.MODE_PRIVATE);
                String SoBan = sharedPref.getString("SoBan", "").trim();
                XoaSP(SoBan, imageModel.getMaSanPham());
                return false;
            }

        });

    }
    //Thong Bao
    private void ThongBao(String tieuDe, String noiDung, final String maBan)
    {
        final Dialog dialog = new Dialog(mcontext);
        dialog.setTitle("Thông Báo");
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.thongbao);

        Button BT_XacNhan = dialog.findViewById(R.id.BT_XacNhan);
        final TextView TV_ThongBao  = dialog.findViewById(R.id.TV_ThongBao);
        final TextView TV_NoiDung  = dialog.findViewById(R.id.TV_NoiDung);
        TV_ThongBao.setText(tieuDe);
        TV_NoiDung.setText(noiDung);
        BT_XacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
                //rết lại trang
                Intent intent = new Intent(mcontext, Activity_HoaDon.class);
                intent.putExtra("SoBan", maBan);
                intent.putExtra("TenBan", "Bàn Số 01");
                intent.putExtra("TrangThai", 1);
                mcontext.startActivity(intent);
            }
        });
        dialog.show();

    }
    //themsp vao hd
    public void ThemSP(final String maSP, final String maDVT, final int soLuong, final int GTDK, final String maNV, final String soBan, final String tenSP)
    {
        //Toast.makeText(mcontext,  maSP+" "+maDVT+" "+soLuong+" "+GTDK+" "+soBan+" "+maNV, Toast.LENGTH_SHORT).show();

        String URL = "http://" + ip + "/LARAVEL/public/api/DonHang/"+soBan;

        RequestQueue requestQueue = Volley.newRequestQueue(mcontext);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //hien thong bao
                    String TieuDe = "Thêm Thành Công";
                    String NoiDung = tenSP;
                    ThongBao( TieuDe, NoiDung, soBan );
                    //Toast.makeText(mcontext,  "Đã Thêm Sản Phẩm Vào Giỏ Hàng", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String TieuDe = "Thêm Thất Bại";
                String NoiDung = "Vui Lòng Thử Lại";
                ThongBao( TieuDe, NoiDung, soBan);
            }
        }){
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("MaSP", maSP);
                params.put("MaDVT", maDVT);
                params.put("SoLuong", String.valueOf(soLuong));
                params.put("MaNV", maNV);
                params.put("DonGia", String.valueOf(GTDK));
                return params;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Conten-Tupe", "application/x-www-form-urlencoded");
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }
    //xoa
    private void XoaSP(final String soBan, final String maSanPham)
    {
        String URL = "http://" + ip + "/LARAVEL/public/api/DonHang/"+soBan+"-"+maSanPham;

        RequestQueue requestQueue = Volley.newRequestQueue(mcontext);
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //hien thong bao
                    String TieuDe = "Xóa Thành Công";
                    String NoiDung = maSanPham;
                    ThongBao( TieuDe, NoiDung, soBan );
                    //Toast.makeText(mcontext,  "Đã Thêm Sản Phẩm Vào Giỏ Hàng", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String TieuDe = "óa Thất Bại";
                String NoiDung = "Vui Lòng Thử Lại";
                ThongBao( TieuDe, NoiDung, soBan);
            }
        }){
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Conten-Tupe", "application/x-www-form-urlencoded");
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }
}
