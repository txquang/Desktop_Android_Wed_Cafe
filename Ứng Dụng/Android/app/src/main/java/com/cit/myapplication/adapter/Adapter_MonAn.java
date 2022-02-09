package com.cit.myapplication.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

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
import com.cit.myapplication.R;
import com.cit.myapplication.info.Info_HoaDon;
import com.cit.myapplication.info.Info_MonAn;
import com.cit.myapplication.viewhoder.ViewHolder_HoaDon;
import com.cit.myapplication.viewhoder.ViewHolder_MonAn;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter_MonAn extends RecyclerView.Adapter<ViewHolder_MonAn>{

    private Context mcontext;
    private List<Info_MonAn> mData = new ArrayList<>();
    String ip = "192.168.43.8";

    //
    public Adapter_MonAn(Context mcontext, List<Info_MonAn> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }
    //
    @NonNull
    @Override
    public ViewHolder_MonAn onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_monan,parent,false);
        ViewHolder_MonAn viewHolder = new ViewHolder_MonAn(item);
        return new ViewHolder_MonAn(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_MonAn holder, final int position) {

        final Info_MonAn imageModel=mData.get(position);
        ViewHolder_MonAn imageItemHolder=(ViewHolder_MonAn) holder;
        imageItemHolder.viewTenMA.setText(imageModel.getTenSP());
        imageItemHolder.viewLoaiMA.setText(imageModel.getTenNhom());
        //fomat lai gia va sl
        int Gia = 0, SoLuong = 0;
        Gia = (int) Double.parseDouble(imageModel.getGTDK());
        //fomat dinh dang
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        imageItemHolder.viewGiaView.setText(decimalFormat.format(Gia)+".₫");
        imageItemHolder.viewSoLuong.append(imageModel.getSLDK());
        switch(imageModel.getMaNhom()) {
            case "MNCF":
                imageItemHolder.viewAnhMA.setImageResource(R.drawable.ic_ma_cafe1);
                break;
            case "MNNU":
                imageItemHolder.viewAnhMA.setImageResource(R.drawable.ic_ma_nuocuon1);
                break;
            case "MNAU":
                imageItemHolder.viewAnhMA.setImageResource(R.drawable.ic_ma_monan1);
                break;
            default:
                imageItemHolder.viewAnhMA.setImageResource(R.drawable.ic_ma_khac1);
        }

        //sk kich vao sp
        holder.viewLinear.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = mcontext.getSharedPreferences("MyPreferences",mcontext.MODE_PRIVATE);
                String MaNV = sharedPref.getString("MaNV", "");
                //Toast.makeText(mcontext,  MaNV, Toast.LENGTH_SHORT).show();
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
                final int SL = 1;
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
                        String MaSP = imageModel.getMaSP().trim();
                        String MaDVT = imageModel.getMaDVT().trim();
                        int SoLuong = seekBar.getProgress();
                        int GTDK = (int) Double.parseDouble(imageModel.getGTDK());
                        String MaNV = sharedPref.getString("MaNV", "").trim();
                        String SoBan = sharedPref.getString("SoBan", "").trim();
                        String TenSP = imageModel.getTenSP().trim();
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
            }
        });

    }
    //hien thong bao
    private void ThongBao(String tieuDe, String noiDung)
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
            }
        });
        dialog.show();

    }
    //themsp vao hd
    public void ThemSP(final String maSP, final String maDVT, final int soLuong, final int GTDK, final String maNV, String soBan, final String tenSP)
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
                    ThongBao( TieuDe, NoiDung );
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
                ThongBao( TieuDe, NoiDung );
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

    @Override
    public int getItemCount() {

        return mData.size();
    }




}
