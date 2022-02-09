package com.cit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Activity_Login extends AppCompatActivity {

    EditText ET_TaiKhoan,ET_MatKhau;
    String TaiKhoan, MatKhau, URL, MaNV, TenNV, DienThoai;
    public Button BT_DangNhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AnhXa();
        BT_DangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Activity_Login.this, Activity_TrangChu.class));
                TaiKhoan = ET_TaiKhoan.getText().toString().trim();
                MatKhau = ET_MatKhau.getText().toString().trim();
                if(TextUtils.isEmpty(TaiKhoan)) {
                    ET_TaiKhoan.setError("Tài Khoản Không Được Để Trống");
                    return;
                }
                if(TextUtils.isEmpty(MatKhau)) {
                    ET_MatKhau.setError("Mật Khẩu Không Được Để Trống");
                    return;
                }
                sendLoginInfo(TaiKhoan, MatKhau);

            }
        });
    }
    public  void sendLoginInfo(final String TaiKhoan, final String Matkhau)
    {
        //" + getString(R.string.DiaChi) + "
        URL = "http://192.168.43.8/LARAVEL/public/api/DangNhap/123";
        RequestQueue requestQueue = Volley.newRequestQueue(Activity_Login.this);
        StringRequest stringRequest = new StringRequest(Request.Method.PUT, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    KiemTra(jsonObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(Activity_Login.this, error.toString(), Toast.LENGTH_SHORT).show();
                String TieuDe = "Lỗi Mạng";
                String NoiDung = "Vui Lòng Kiểm Tra internet";
                ThongBao(TieuDe, NoiDung, 1);

            }
        }){
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("TaiKhoan", TaiKhoan);
                params.put("MatKhau", Matkhau);
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
    public void KiemTra(JSONObject Json) throws JSONException {

        if (Json.getString("result").trim().equals("success"))
        {
            SharedPreferences sharedPref = getSharedPreferences("MyPreferences", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("MaNV", Json.getString("MaNV").trim() );
            editor.putString("HoTen", Json.getString("HoTen").trim() );
            editor.putString("DienThoai", Json.getString("DienThoai").trim() );
            editor.commit();
            //goi thong bao
            String TieuDe = "Xin Chào Nhân Viên";
            String NoiDung = Json.getString("HoTen").trim();
            ThongBao( TieuDe, NoiDung ,0);
            //Toast.makeText(Activity_Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
        else {
            //goi thong bao
            String TieuDe = "Sai Tài Khoản, Mật Khẩu";
            String NoiDung = "Vui Lòng Thử Lại";
            ThongBao(TieuDe, NoiDung, 1);
            //Toast.makeText(Activity_Login.this, "Sai Tài Khoản Hoặc Mật Khẩu !", Toast.LENGTH_SHORT).show();
        }
    }
    public void AnhXa()
    {
        BT_DangNhap = findViewById(R.id.LG_BT_Dangnhap);
        ET_TaiKhoan = findViewById(R.id.LG_ET_Email);
        ET_MatKhau = findViewById(R.id.LG_ET_Pass);
    }
    private void ThongBao(String tieuDe, String noiDung, final Integer So)
    {
        final Dialog dialog = new Dialog(Activity_Login.this);
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
                if( So ==1 )
                    dialog.cancel();
                else
                {
                    dialog.cancel();
                    startActivity(new Intent(Activity_Login.this, Activity_TrangChu.class));
                }
            }
        });
        dialog.show();

    }
}
