package com.cit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cit.myapplication.R;
import com.cit.myapplication.adapter.Adapter_TrangChu;
import com.cit.myapplication.congketnoi.NetworkResponseListener_KhuVuc;
import com.cit.myapplication.info.Info_TrangChu;
import com.cit.myapplication.ketnoi.Task_KhuVuc;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Activity_KhuVuc extends AppCompatActivity implements NetworkResponseListener_KhuVuc {

    TextView viewTheLoai, viewSolLuong;
    LinearLayout viewAnhSP;
    //recyview
    private RecyclerView RC_KV;
    private ProgressBar progressBar;
    String MaKV, TenKV, URL;
    int AnhKV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__khu_vuc);

        AnhXa();

        Intent intent = getIntent();
        MaKV = intent.getExtras().getString("MaKV");
        TenKV = intent.getExtras().getString("TenKV");
        AnhKV = intent.getExtras().getInt("AnhKV");

        if ( AnhKV ==1 )
            viewAnhSP.setBackgroundResource(R.drawable.im_ngoaitroi);
        else
            viewAnhSP.setBackgroundResource(R.drawable.im_trongnha);


        //gan gia trị
        viewTheLoai.setText(TenKV);
        // goi api
        URL = "http://"+getString(R.string.DiaChi)+"/LARAVEL/public/api/KhuVuc/"+MaKV;
        Task_KhuVuc task_khuVuc = new Task_KhuVuc(Activity_KhuVuc.this, URL);
        task_khuVuc.execute();
    }

    private void AnhXa() {
        progressBar= findViewById(R.id.progress);
        RC_KV = findViewById(R.id.TL_RC_KhuVuc);
        viewAnhSP = findViewById(R.id.TL_Liner);
        viewTheLoai = findViewById(R.id.TL_TV_TheLoai);
        viewSolLuong = findViewById(R.id.TL_TV_SoLuong);
    }

    @Override
    public void SuccessData(String data) {
        try
        {
            List<Info_TrangChu> info_trangChu =new ArrayList<>();
            JSONArray jsonArray = new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++) {
                info_trangChu.add(
                        new Info_TrangChu(
                                jsonArray.getJSONObject(i).getString("SoBan"),
                                jsonArray.getJSONObject(i).getString("MaKV"),
                                jsonArray.getJSONObject(i).getString("TenBan"),
                                jsonArray.getJSONObject(i).getString("NoUse")
                        )
                );
            }
            viewSolLuong.setText("Tổng Cộng Có: "+jsonArray.length()+" Bàn");
            Adapter_TrangChu imageItemAdapter=new Adapter_TrangChu(this,info_trangChu);
            RC_KV.setLayoutManager(new GridLayoutManager(this,3));
            RC_KV.setAdapter(imageItemAdapter);

            progressBar.setVisibility(View.GONE);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        progressBar.setVisibility(View.GONE);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void FailedData() {
        Toast.makeText(this, "Vui Lòng Kiểm Tra IP Máy Tính: "+getString(R.string.DiaChi), 20000).show();

    }
}
