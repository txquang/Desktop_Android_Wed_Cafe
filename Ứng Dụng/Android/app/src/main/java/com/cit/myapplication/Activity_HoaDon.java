package com.cit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.cit.myapplication.adapter.Adapter_HoaDon;
import com.cit.myapplication.congketnoi.NetworkResponseListener_HoaDon;
import com.cit.myapplication.info.Info_HoaDon;
import com.cit.myapplication.ketnoi.Task_HoaDon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity_HoaDon extends AppCompatActivity implements NetworkResponseListener_HoaDon {

    private ProgressBar progressBar;
    private RecyclerView RC_HD;
    TextView TV_TenBan;
    private Button BT_ThemSP, BT_TongTien, BT_ThanhToan, BT_TroLai;
    private String SoBan, TenBan, TrangThai;
    private String URL;
    int TongTien=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon);

        //lay ds san pham
        Intent intent = this.getIntent();
        SoBan = intent.getExtras().getString("SoBan");
        TenBan = intent.getExtras().getString("TenBan");
        TrangThai = intent.getExtras().getString("TrangThai");

        AnhXa();

        //load du lieu
        URL = "http://"+getString(R.string.DiaChi)+"/LARAVEL/public/api/DonHang/"+SoBan;
        Task_HoaDon task_hoaDon = new Task_HoaDon(Activity_HoaDon.this, URL);
        task_hoaDon.execute();

    }
    //them load lai trang
    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }


    public void AnhXa()
    {
        progressBar= findViewById(R.id.progress);
        RC_HD = findViewById(R.id.RC_HD);

        TV_TenBan = findViewById(R.id.HD_TV_TenBan);
        BT_ThemSP = findViewById(R.id.HD_BT_ThemMon);
        BT_ThanhToan = findViewById(R.id.HD_BT_ThanhToan);
        BT_TongTien = findViewById(R.id.HD_BT_TongTien);
        BT_TroLai = findViewById(R.id.HD_BT_Trolai);

        //gan gia trị cho ban
        TV_TenBan.setText(TenBan);
        //them sp
        BT_ThemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_HoaDon.this, Activity_MonAn.class);
                intent.putExtra("SoBan", SoBan);
                intent.putExtra("TenBan", TenBan);
                intent.putExtra("TrangThai", TrangThai);
                startActivity(intent);
            }
        });
        BT_TroLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Qauy lai trang chu
                startActivity(new Intent(Activity_HoaDon.this, Activity_TrangChu.class));
            }
        });
        //kcick thanh toan
        BT_ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = getSharedPreferences("MyPreferences",MODE_PRIVATE);
                String MaNV = sharedPref.getString("MaNV", "").trim();
                //goi thanh toan
                ThanhToan( MaNV, SoBan, TongTien );
            }
        });
    }
    //thanh toan
    private void ThanhToan(final String maNV, final String soBan, final int tongTien) {
        //Toast.makeText(Activity_HoaDon.this, maNV+"   "+soBan+" "+tongTien, Toast.LENGTH_SHORT).show();

        URL = "http://" + getString(R.string.DiaChi) + "/LARAVEL/public/api/DonHang";
        RequestQueue requestQueue = Volley.newRequestQueue(Activity_HoaDon.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String TieuDe = "Thanh Toán Thành Công";
                    String NoiDung = soBan;
                    ThongBao( TieuDe, NoiDung );
                    //Toast.makeText(Activity_HoaDon.this,  "Đã Thêm Sản Phẩm Vào Giỏ Hàng", Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String TieuDe = "Thanh Toán Thất Bại";
                String NoiDung = "Vui Lòng Thử Lại";
                ThongBao( TieuDe, NoiDung );//Toast.makeText(Activity_HoaDon.this, "Kiểm Tra Kết Nối Mạng", Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("SoBan", soBan);
                params.put("MaNV", maNV);
                params.put("SoTien", String.valueOf(tongTien));
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
    //hien thong bao
    private void ThongBao(String tieuDe, String noiDung)
    {
        final Dialog dialog = new Dialog(Activity_HoaDon.this);
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
                //Qauy lai trang chu
                startActivity(new Intent(Activity_HoaDon.this, Activity_TrangChu.class));
            }
        });
        dialog.show();

    }

    @Override
    public void SuccessData(String data) {
        try
        {
            List<Info_HoaDon> info_hoaDon =new ArrayList<>();
            JSONArray jsonArray = new JSONArray(data);
            int SL, Gia, ThanhTien;
            //dinh dang
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            for (int i=0;i<jsonArray.length();i++)
            {
                //chiuyen so
                SL = (int) Double.parseDouble( jsonArray.getJSONObject(i).getString("SoLuong") );
                Gia = (int) Double.parseDouble( jsonArray.getJSONObject(i).getString("DonGia") );
                ThanhTien = SL*Gia;
                TongTien += ThanhTien;

                //add vao rec
                info_hoaDon.add(
                        new Info_HoaDon(
                                jsonArray.getJSONObject(i).getString("MaSP"),
                                jsonArray.getJSONObject(i).getString("TenSP"),
                                SL,
                                Gia,
                                ThanhTien,
                                jsonArray.getJSONObject(i).getString("MaNhom")
                        )
                );

            }
            Adapter_HoaDon imageItemAdapter=new Adapter_HoaDon(this,info_hoaDon);
            RC_HD.setLayoutManager(new LinearLayoutManager(this));
            RC_HD.setAdapter(imageItemAdapter);
            //
            BT_TongTien.setText("Tổng Tiền: "+decimalFormat.format(TongTien)+".₫");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void FailedData() {

    }

}